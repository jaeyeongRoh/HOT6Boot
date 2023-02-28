package com.hotsix.titans.salary.entity;

import com.hotsix.titans.member.entity.Member;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_SALARY")
//@SequenceGenerator(
//    name = "SALARY_SEQ_GENERATOR",
//    sequenceName = "SEQ_SALARY",
//    initialValue = 1,
//    allocationSize = 50
//)
public class Salary {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SALARY")
    @Column(name = "SALARY_CODE")
    private String salaryCode;              // 급여 코드

    @Column(name = "BASIC_SALARY")
    private Long basicSalary;               // 기본급

    @Column(name = "BEFORE_SALARY")
    private Long beforeSalary;              // 세전 급액

    @Column(name = "AFTER_SALARY")
    private Long afterSalary;               // 세후 급액

    @Column(name = "MEAL_SALARY")
    private Long mealSalary;                // 식대

    @Column(name = "HEALTH_TAX")
    private Long healthTax;

    @Column(name = "NATIONAL_TAX")
    private Long nationalTax;

    @Column(name = "PAYMENT_YEAR")
    private Date paymentYear;

    @Column(name = "PAYMENT_MONTH")
    private Date paymentMonth;

    @Column(name = "SALARY_PAYMENTS_YN")
    private String paymentsYn;

    @ManyToOne
    @JoinColumn(name = "TAX_CODE")
    private Tax tax;

    @OneToMany
    @JoinColumn(name = "BONUS_CODE")
    private List<Bonus> bonusList;

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE")
    private Member member;

    public Salary() {
    }

    public Salary(String salaryCode, Long basicSalary, Long beforeSalary, Long afterSalary, Long mealSalary, Long healthTax, Long nationalTax, Date paymentYear, Date paymentMonth, String paymentsYn, Tax tax, List<Bonus> bonusList, Member member) {
        this.salaryCode = salaryCode;
        this.basicSalary = basicSalary;
        this.beforeSalary = beforeSalary;
        this.afterSalary = afterSalary;
        this.mealSalary = mealSalary;
        this.healthTax = healthTax;
        this.nationalTax = nationalTax;
        this.paymentYear = paymentYear;
        this.paymentMonth = paymentMonth;
        this.paymentsYn = paymentsYn;
        this.tax = tax;
        this.bonusList = bonusList;
        this.member = member;
    }

    public String getSalaryCode() {
        return salaryCode;
    }

    public void setSalaryCode(String salaryCode) {
        this.salaryCode = salaryCode;
    }

    public Long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Long getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Long beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Long getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Long afterSalary) {
        this.afterSalary = afterSalary;
    }

    public Long getMealSalary() {
        return mealSalary;
    }

    public void setMealSalary(Long mealSalary) {
        this.mealSalary = mealSalary;
    }

    public Long getHealthTax() {
        return healthTax;
    }

    public void setHealthTax(Long healthTax) {
        this.healthTax = healthTax;
    }

    public Long getNationalTax() {
        return nationalTax;
    }

    public void setNationalTax(Long nationalTax) {
        this.nationalTax = nationalTax;
    }

    public Date getPaymentYear() {
        return paymentYear;
    }

    public void setPaymentYear(Date paymentYear) {
        this.paymentYear = paymentYear;
    }

    public Date getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(Date paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public String getPaymentsYn() {
        return paymentsYn;
    }

    public void setPaymentsYn(String paymentsYn) {
        this.paymentsYn = paymentsYn;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public List<Bonus> getBonusList() {
        return bonusList;
    }

    public void setBonusList(List<Bonus> bonusList) {
        this.bonusList = bonusList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryCode='" + salaryCode + '\'' +
                ", basicSalary=" + basicSalary +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
                ", mealSalary=" + mealSalary +
                ", healthTax=" + healthTax +
                ", nationalTax=" + nationalTax +
                ", paymentYear=" + paymentYear +
                ", paymentMonth=" + paymentMonth +
                ", paymentsYn='" + paymentsYn + '\'' +
                ", tax=" + tax +
                ", bonusList=" + bonusList +
                ", member=" + member +
                '}';
    }
}
