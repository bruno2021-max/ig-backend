
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadAllEmployByRoleMapper;

@Component
public class SPLoadAllSupervisorForDefuse extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_ALL_SUPERVISOR_FOR_DEFUSE";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_EMPLOY_PK = "@inEmployPK";
    public static final String IN_LOGIN_EMPLOY_PK = "@inLoginEmployPK";

    @Autowired
    public SPLoadAllSupervisorForDefuse(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMPLOY_PK, IN_LOGIN_EMPLOY_PK)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_EMPLOY_PK, Types.BIGINT),
                        new SqlParameter(IN_LOGIN_EMPLOY_PK, Types.BIGINT))
                .returningResultSet(OUT_CURSOR, new LoadAllEmployByRoleMapper());
    }
}
