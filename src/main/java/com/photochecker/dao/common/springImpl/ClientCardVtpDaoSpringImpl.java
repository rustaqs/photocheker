package com.photochecker.dao.common.springImpl;

import com.photochecker.dao.common.ClientCardVtpDao;
import com.photochecker.model.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Transactional
@Repository
public class ClientCardVtpDaoSpringImpl implements ClientCardVtpDao {

    //language=SQL
    private final String SQL_FIND_BY_ID = "select * from `client_card_vtp` cc where `client_id`=? order by 2";
    //language=SQL
    private final String SQL_FIND_ALL="select * from `client_card_vtp` cc order by 4";
    //language=SQL
    private final String SQL_FIND_Region="select distinct cc.region_id, cc.region from `client_card_vtp` cc order by cc.region_id";
    //language=SQL
    private final String SQL_FIND_Region_id="select distinct cc.region_id, cc.region from `client_card_vtp` cc where cc.region_id=?";
    //language=SQL
    private final String SQL_FIND_Distr_id="select distinct cc.region_id, cc.distr_id, cc.distr from `client_card_vtp` cc where cc.distr_id=?";
    //language=SQL
    private final String SQL_FIND_Distr="select distinct cc.distr_id, cc.distr, cc.region_id from `client_card_vtp` cc where cc.region_id= ?";
    //language=SQL
    private final String SQL_FIND_Vtp="select distinct cc.sector_id, cc.fio, cc.distr_id from `client_card_vtp` cc where cc.distr_id= ?";
    //language=SQL
    private final String SQL_DeleteAll = "delete FROM client_card_vtp where id>0";
    //language=SQL
    private final String SQL_SavAns = "INSERT INTO `answer` (`id`, `answer`, `creation_time`, `nameauditor`, `namevtp`, `question`, `time`, `type`,`vizNum`, `stage`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 //language=SQL
    private final String SQL_SAVE = "INSERT INTO `client_card_vtp`\n" +
            "(`id`,`region_id`,`region`,`city`, `distr`, `client_name`,`client_id`,`client_address`,`fio`,`kanal`,`type`,`distr_id`,`job`, `sector_name`,`sector_id`)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    //language=SQL
    private final String SQL_Grade="SELECT\n" +
            "  a4.Date date,\n" +
            "  CASE WHEN a4.stage = 1\n" +
            "    THEN 'Подготовка к рабочему дню'\n" +
            "  WHEN a4.stage = 2\n" +
            "    THEN 'Этапы визита'\n" +
            "  WHEN a4.stage = 3\n" +
            "    THEN 'Итоги обучения' END stage,\n" +
            "  CASE WHEN a4.stage = 1\n" +
            "    THEN sum(a4.grade) / count(a4.grade)\n" +
            "  WHEN a4.stage = 3\n" +
            "    THEN a4.grade\n" +
            "  WHEN sum(a4.grade) >= 10\n" +
            "    THEN 5\n" +
            "  WHEN sum(a4.grade) >= 7 AND sum(a4.grade) <= 9\n" +
            "    THEN 4\n" +
            "  WHEN sum(a4.grade) >= 5 AND sum(a4.grade) <= 6\n" +
            "    THEN 3\n" +
            "  WHEN sum(a4.grade) >= 3 AND sum(a4.grade) <= 4\n" +
            "    THEN 2\n" +
            "  WHEN sum(a4.grade) >= 1 AND sum(a4.grade) <= 2\n" +
            "    THEN 1\n" +
            "  END                              grade\n" +
            "FROM (SELECT DISTINCT\n" +
            "        a3.Date,\n" +
            "        a3.stage,\n" +
            "        a3.type,\n" +
            "        CASE WHEN a3.`%` > 100\n" +
            "          THEN a3.`%` / 100\n" +
            "        WHEN a3.`%` >= 70\n" +
            "          THEN 1\n" +
            "        ELSE 0 END 'grade'\n" +
            "      FROM (SELECT\n" +
            "              a2.Date,\n" +
            "              a2.stage,\n" +
            "              a2.nameauditor,\n" +
            "              a2.namevtp,\n" +
            "              a2.type,\n" +
            "              sum(a2.Answ),\n" +
            "              sum(a2.vizNum),\n" +
            "              (sum(a2.Answ) / sum(a2.vizNum)) * 100 '%'\n" +
            "            FROM (\n" +
            "                   SELECT\n" +
            "                     a.stage,\n" +
            "                     a.nameauditor,\n" +
            "                     a.namevtp,\n" +
            "                     cast(left(a.time, 10) AS DATE) Date,\n" +
            "                     a.type,\n" +
            "                     a.question,\n" +
            "                     CASE WHEN a.answer = '+' OR a.answer = '0'\n" +
            "                       THEN 1\n" +
            "                     WHEN a.answer = '1' OR a.answer = '2' OR a.answer = '3' OR a.answer = '4' OR a.answer = '5'\n" +
            "                       THEN a.answer\n" +
            "                     ELSE 0 END                     Answ,\n" +
            "                     CASE WHEN a.vizNum > 0\n" +
            "                       THEN 1\n" +
            "                     ELSE 0 END                     vizNum\n" +
            "                   FROM answer a\n" +
            "                   WHERE cast(left(a.time, 10) AS DATE) = (SELECT max(cast(left(b.time, 10) AS DATE)) date\n" +
            "                                                           FROM answer b) and a.namevtp = ?)\n" +
            "                 a2\n" +
            "            GROUP BY a2.stage, a2.nameauditor, a2.Date, a2.type)\n" +
            "           a3)\n" +
            "     a4\n" +
            "GROUP BY a4.stage, a4.Date";

    private JdbcTemplate jdbcTemplate;
    private List<ClientCardVtp> clientCardVtpList;
    private RowMapper<ClientCardVtp> clientCardVtpRowMapper = (resultSet, i) -> {
        ClientCardVtp clientCardVtp = new ClientCardVtp(
                resultSet.getInt("region_id"),
                resultSet.getString("region").trim(),
                resultSet.getString("city"),
                resultSet.getString("distr"),
                resultSet.getString("client_name"),
                resultSet.getInt("client_id"),
                resultSet.getString("client_address"),
                resultSet.getString("fio"),
                resultSet.getString("kanal"),
                resultSet.getString("type"),
                resultSet.getInt("distr_id"),
                resultSet.getString("job"),
                resultSet.getString("sector_name"),
                resultSet.getInt("sector_id"));
        return clientCardVtp;
    };
  /*  private RowMapper<ClientCardVtp> clientCVtpRM = (resultSet, i) -> {

        ClientCardVtp clientCardVtp = new ClientCardVtp(
                resultSet.getInt("region_id"),
                resultSet.getString("region").trim(),
                resultSet.getString("city"),
                resultSet.getString("distr"),
                resultSet.getString("client_name"),
                resultSet.getInt("client_id"),
                resultSet.getString("client_address"),
                resultSet.getString("fio"),
                resultSet.getString("kanal"),
                resultSet.getString("type"),
                resultSet.getInt("distr_id"),
                resultSet.getString("job"),
                resultSet.getString("sector_name"),
                resultSet.getInt("sector_id"));
        return clientCardVtp;
    };*/
    private RowMapper<Region> regionMapper = (resultSet, i) -> {
        Region region = new Region( resultSet.getInt("region_id"),
                resultSet.getString("region"));
        return region;
    };
    private List<Region> regionList;

    private RowMapper<Distr> distrMapper = (resultSet, i) -> {
        int region_id = resultSet.getInt("region_id");
        List<Region> region = jdbcTemplate.query(SQL_FIND_Region_id,regionMapper, region_id);
        return new Distr(resultSet.getInt("distr_id"),
                resultSet.getString("distr"),
                region.get(0)
        );
    };
    private RowMapper<Vtp> vtpMapper = (resultSet, i) -> {
        int distr_id = resultSet.getInt("distr_id");
        List<Distr> distr = jdbcTemplate.query(SQL_FIND_Distr_id,distrMapper, distr_id);
        return new Vtp(resultSet.getInt("sector_id"),
                resultSet.getString("fio"),
                distr.get(0)
        );
    };
    private RowMapper<Grade> gradeRowMapper = (resultSet, i) -> {
        Grade grade = new Grade( resultSet.getDate("date"),
                resultSet.getString("stage"),
                resultSet.getDouble("grade"));
        return grade;
    };
    @Autowired
    public ClientCardVtpDaoSpringImpl(@Qualifier("dataSource") DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public int save(ClientCardVtp clientCardVtp) {
        return jdbcTemplate.update(SQL_SAVE,
                clientCardVtp.getId(),
                clientCardVtp.getRegion_id(),
                clientCardVtp.getRegion(),
                clientCardVtp.getCity(),
                clientCardVtp.getDistr(),
                clientCardVtp.getClient_name(),
                clientCardVtp.getClient_id(),
                clientCardVtp.getClient_address(),
                clientCardVtp.getFio(),
                clientCardVtp.getKanal(),
                clientCardVtp.getType(),
                clientCardVtp.getDist_id(),
                clientCardVtp.getJob(),
                clientCardVtp.getSector_name(),
                clientCardVtp.getSector_id());
    }
    @Override
    public ClientCardVtp find(int id) {
        List<ClientCardVtp> result = jdbcTemplate.query(SQL_FIND_BY_ID, clientCardVtpRowMapper, id);
        return result.size() > 0 ? result.get(0) : null;
    }
    @Override
    public List<ClientCardVtp> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, clientCardVtpRowMapper);
    }
    @Override
    public boolean update(ClientCardVtp clientCardVtpDao) {
        return false;
    }
    @Override
    public void remove(ClientCardVtp clientCardVtp) {
    }
    @Override
    public void remove() {
        jdbcTemplate.update(SQL_DeleteAll);
    }
    @Override
    public List<Region> findlistRegion () {
        return jdbcTemplate.query(SQL_FIND_Region,regionMapper);
    }
    @Override
    public List<Distr> findlistDistr(int regionid){
        return jdbcTemplate.query(SQL_FIND_Distr,distrMapper, regionid);
    }
    @Override
    public List<Vtp> findlistVtp(int distrid){
        return jdbcTemplate.query(SQL_FIND_Vtp,vtpMapper, distrid);
    }
    public String getGrade(String fio){
        List<Grade> grade = jdbcTemplate.query(SQL_Grade,gradeRowMapper, fio);
        String gradeText="Дата проведения: " + grade.get(0).getDate() + ". " + grade.get(0).getStage() + ": Оценка - " +
                grade.get(0).getGrade() + ". " + grade.get(1).getStage() + ": Оценка - " +
                grade.get(1).getGrade() + ". " + grade.get(2).getStage() + ": Оценка - " +
                grade.get(2).getGrade() + ".";
        return gradeText;
    }
    @Override
    public void saveA (Answer answer){
         jdbcTemplate.update(SQL_SavAns, answer.getId(),
                answer.getAnswer(),
                answer.getCreationTime(),
                answer.getNameauditor(),
                answer.getNamevtp(),
                answer.getQuestion(),
                answer.getTime(),
                answer.getType(),
                answer.getVizNum(),
                answer.getStage());
    }
/*
    public List<ClientCardVtp> findlistClientN(int vtpid){
        return jdbcTemplate.query(SQL_FIND_ClientN,clientNMapper, vtpid);
    }
*/

}
