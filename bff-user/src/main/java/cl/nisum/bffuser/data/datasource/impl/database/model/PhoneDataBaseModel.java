package cl.nisum.bffuser.data.datasource.impl.database.model;


import javax.persistence.*;
import java.math.BigDecimal;


@Table(name = "phone")
@Entity
public class PhoneDataBaseModel {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "number", nullable = false)
    private String number ;

    @Column(name = "city_code", nullable = false)
    private BigDecimal cityCode;

    @Column(name = "country_code", nullable = false)
    private BigDecimal countryCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getCityCode() {
        return cityCode;
    }

    public void setCityCode(BigDecimal cityCode) {
        this.cityCode = cityCode;
    }

    public BigDecimal getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(BigDecimal countryCode) {
        this.countryCode = countryCode;
    }
}
