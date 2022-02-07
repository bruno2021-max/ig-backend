
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadEmployTrazeMapper;

@Component
public class SPLoadEmployTraze extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_EMPLOY_TRAZE";
    // PARAMETROS
    public static final String OUT_CURSOR = "salCursor";
    public static final String OUT_STATUS = "saltStatus";

    @Autowired
    public SPLoadEmployTraze(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR))
                .returningResultSet(OUT_CURSOR, new LoadEmployTrazeMapper());

    }

}
