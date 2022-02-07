
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUpdateOfficerEmploy extends CPStoredProcedure
{

    private static final String SP_NAME = "P_UPDATE_OFFICER_EMPLOY";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_EMPLOY_PK = "@inEmployPk";
    public static final String IN_PASSWORD = "@inPassword";
    public static final String IN_NAME = "@inName";
    public static final String IN_APPAT = "@inApePat";
    public static final String IN_APMAT = "@inApeMat";
    public static final String IN_GENDER = "@inGender";
    public static final String IN_MOBILE = "@inMobile";
    public static final String IN_EMAIL = "@inEmail";
    public static final String IN_AREA_FK = "@inAreaFk";
    public static final String IN_EMPLOY_FK = "@inEmployFk";
    public static final String IN_LOGIN_EMPLOY_PK = "@inLoginEmployPK";

    @Autowired
    public SPUpdateOfficerEmploy(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
                .useInParameterNames(IN_EMPLOY_PK, IN_PASSWORD, IN_NAME, IN_APPAT, IN_APMAT, IN_GENDER, IN_MOBILE,
                        IN_EMAIL, IN_AREA_FK, IN_EMPLOY_FK, IN_LOGIN_EMPLOY_PK)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_EMPLOY_PK, Types.BIGINT), new SqlParameter(IN_PASSWORD, Types.VARCHAR),
                        new SqlParameter(IN_NAME, Types.VARCHAR), new SqlParameter(IN_APPAT, Types.VARCHAR),
                        new SqlParameter(IN_APMAT, Types.VARCHAR), new SqlParameter(IN_GENDER, Types.VARCHAR),
                        new SqlParameter(IN_MOBILE, Types.VARCHAR), new SqlParameter(IN_EMAIL, Types.VARCHAR),
                        new SqlParameter(IN_AREA_FK, Types.BIGINT), new SqlParameter(IN_EMPLOY_FK, Types.BIGINT),
                        new SqlParameter(IN_LOGIN_EMPLOY_PK, Types.BIGINT));
    }
}