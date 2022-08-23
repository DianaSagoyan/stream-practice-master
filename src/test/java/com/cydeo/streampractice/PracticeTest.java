package com.cydeo.streampractice;

import com.cydeo.streampractice.bootstrap.DataGenerator;
import com.cydeo.streampractice.model.*;
import com.cydeo.streampractice.practice.Practice;
import com.cydeo.streampractice.service.*;
import com.cydeo.streampractice.service.impl.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class PracticeTest {
    private static final double DELTA = 1e-15;

    private DataGenerator dataGenerator;
    private Practice practice;
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private JobHistoryService jobHistoryService;
    private CountryService countryService;
    private JobService jobService;
    private LocationService locationService;
    private RegionService regionService;

    @Before
    public void setup() throws Exception {
        employeeService = new EmployeeServiceImpl();
        departmentService = new DepartmentServiceImpl();
        jobHistoryService = new JobHistoryServiceImpl();
        countryService = new CountryServiceImpl();
        jobService = new JobServiceImpl();
        locationService = new LocationServiceImpl();
        regionService = new RegionServiceImpl();
        dataGenerator = new DataGenerator(countryService, departmentService,
                employeeService, jobHistoryService,
                jobService, locationService, regionService);
        practice = new Practice(countryService, departmentService,
                employeeService, jobHistoryService,
                jobService, locationService, regionService);
        dataGenerator.run();
    }

    @Test
    public void shouldGetAllEmployees() {
        List<Employee> employeeList = Practice.getAllEmployees();
        int exceptedValue = 107;
        Assert.assertEquals(exceptedValue, employeeList.size());
    }

    @Test
    public void shouldGetAllCountries() {
        List<Country> countryList = Practice.getAllCountries();
        int exceptedValue = 25;
        Assert.assertEquals(exceptedValue, countryList.size());
    }

    @Test
    public void shouldGetAllDepartments() {
        List<Department> departmentList = Practice.getAllDepartments();
        int exceptedValue = 27;
        Assert.assertEquals(exceptedValue, departmentList.size());
    }

    @Test
    public void shouldGetAllJobs() {
        List<Job> jobList = Practice.getAllJobs();
        int exceptedValue = 19;
        Assert.assertEquals(exceptedValue, jobList.size());
    }

    @Test
    public void shouldGetAllLocations() {
        List<Location> locationList = Practice.getAllLocations();
        int exceptedValue = 23;
        Assert.assertEquals(exceptedValue, locationList.size());
    }

    @Test
    public void shouldGetAllRegions() {
        List<Region> regionList = Practice.getAllRegions();
        int exceptedValue = 4;
        Assert.assertEquals(exceptedValue, regionList.size());
    }

    @Test
    public void shouldGetAllJobHistories() {
        List<JobHistory> jobHistoryList = Practice.getAllJobHistories();
        int exceptedValue = 10;
        Assert.assertEquals(exceptedValue, jobHistoryList.size());
    }

    @Test
    public void shouldGetAllEmployeesFirstName() {
        List<Employee> employeeList = Practice.getAllEmployees();
        List<String> nameList = Practice.getAllEmployeesFirstName();
        Assert.assertNotEquals(0, employeeList.size());
        Assert.assertNotEquals(0, nameList.size());
        Assert.assertEquals(employeeList.size(), nameList.size());
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            String randomName = nameList.get(i);
            if (!employee.getFirstName().equals(randomName)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    Assert.fail();
                }
            }
        }
    }

    @Test
    public void shouldGetAllCountryNames() {
        List<Country> countryList = Practice.getAllCountries();
        List<String> nameList = Practice.getAllCountryNames();
        Assert.assertNotEquals(0, countryList.size());
        Assert.assertNotEquals(0, nameList.size());
        Assert.assertEquals(countryList.size(), nameList.size());
        for (int i = 0; i < countryList.size(); i++) {
            Country country = countryList.get(i);
            String randomName = nameList.get(i);
            if (!country.getCountryName().equals(randomName)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    Assert.fail();
                }
            }
        }
    }

    @Test
    public void shouldGetAllDepartmentManagerFirstNames() {
        List<Department> departmentList = Practice.getAllDepartments();
        List<String> nameList = Practice.getAllDepartmentManagerFirstNames();
        Assert.assertNotEquals(0, departmentList.size());
        Assert.assertNotEquals(0, nameList.size());
        Assert.assertEquals(departmentList.size(), nameList.size());
        for (int i = 0; i < departmentList.size(); i++) {
            Department department = departmentList.get(i);
            String randomName = nameList.get(i);
            if (!department.getManager().getFirstName().equals(randomName)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    Assert.fail();
                }
            }
        }
    }

    @Test
    public void shouldGetAllDepartmentsWhichManagerFirstNameIsSteven() {
        List<Department> departmentList = Practice.getAllDepartmentsWhichManagerFirstNameIsSteven();
        Assert.assertEquals(17, departmentList.size());
        Assert.assertEquals("Steven", departmentList.get(0).getManager().getFirstName());
    }

    @Test
    public void shouldGetAllDepartmentsWhereLocationPostalCodeIs98199() {
        List<Department> departmentList = Practice.getAllDepartmentsWhereLocationPostalCodeIs98199();
        Assert.assertEquals(21, departmentList.size());
        Assert.assertEquals("98199", departmentList.get(0).getLocation().getPostalCode());
    }

    @Test
    public void shouldGetRegionOfITDepartment() throws Exception {
        Region region = Practice.getRegionOfITDepartment();
        Assert.assertEquals("Americas", region.getRegionName());
        long expectedValue = 2;
        Assert.assertEquals(expectedValue, region.getId().longValue());
    }

    @Test
    public void shouldGetAllDepartmentsWhereRegionOfCountryIsEurope() {
        List<Department> departmentList = Practice.getAllDepartmentsWhereRegionOfCountryIsEurope();
        Assert.assertEquals(3, departmentList.size());
        Assert.assertEquals("Europe", departmentList.get(0).getLocation().getCountry().getRegion().getRegionName());
    }

    @Test
    public void shouldAllEmployeeSalaryGreaterThan1000() {
        boolean actualValue = Practice.checkIfThereIsNoSalaryLessThan1000();
        Assert.assertTrue(actualValue);
    }

    @Test
    public void shouldAllEmployeeSalaryGreaterThan2000InITDepartment() {
        boolean actualValue = Practice.checkIfThereIsAnySalaryGreaterThan2000InITDepartment();
        Assert.assertTrue(actualValue);
    }

    @Test
    public void shouldGetAllEmployeesWithLessSalaryThan5000() {
        List<Employee> incomeLessThan5000 = Practice.getAllEmployeesWithLessSalaryThan5000();
        int exceptedValue = 49;
        Assert.assertEquals(exceptedValue, incomeLessThan5000.size());
    }

    @Test
    public void shouldGetAllEmployeesSalaryBetween() {
        List<Employee> specificSalaryList = Practice.getAllEmployeesSalaryBetween();
        int exceptedValue = 8;
        Assert.assertEquals(exceptedValue, specificSalaryList.size());
    }

    @Test
    public void shouldGetGrantDouglasSalary() throws Exception {
        long salary = Practice.getGrantDouglasSalary();
        long exceptedValue = 2600L;
        Assert.assertEquals(exceptedValue, salary);
    }

    @Test
    public void shouldGetMaxSalary() throws Exception {
        long maxSalary = Practice.getMaxSalary();
        long exceptedValue = 24000;
        Assert.assertEquals(exceptedValue,maxSalary);
    }

    @Test
    public void shouldGetMaxSalaryEmployee() throws Exception {
        List<Employee> employees = Practice.getMaxSalaryEmployee();
        long actualSalary = 24000;
        Assert.assertEquals(1, employees.size());
        Assert.assertEquals(actualSalary, employees.get(0).getSalary().longValue());
    }

    @Test
    public void shouldGetMaxSalaryEmployeeJob() throws Exception {
        Job job = Practice.getMaxSalaryEmployeeJob();
        Assert.assertEquals("President", job.getJobTitle());
        Assert.assertEquals("AD_PRES", job.getId());
    }

    @Test
    public void shouldGetMaxSalaryInAmericasRegion() throws Exception {
        Long salary = Practice.getMaxSalaryInAmericasRegion();
        Assert.assertEquals(24000L, salary.longValue());
    }

    @Test
    public void shouldGetMaxSecondSalary() throws Exception {
        long maxSalary = Practice.getSecondMaxSalary();
        long expectedSalary = 17000;
        Assert.assertEquals(expectedSalary,maxSalary);
    }

    @Test
    public void shouldGetSecondMaxSalaryEmployee() throws Exception {
        List<Employee> employees = Practice.getSecondMaxSalaryEmployee();
        long actualSalary = 17000;
        Assert.assertEquals(2, employees.size());
        Assert.assertEquals(actualSalary, employees.get(0).getSalary().longValue());
        Assert.assertEquals(actualSalary, employees.get(1).getSalary().longValue());
    }

    @Test
    public void shouldGetMinSalary() throws Exception {
        long maxSalary = Practice.getMinSalary();
        long expectedSalary = 2100;
        Assert.assertEquals(expectedSalary,maxSalary);
    }

    @Test
    public void shouldGetMinSalaryEmployee(){
        List<Employee> employees = Practice.getMinSalaryEmployee();
        long actualSalary = 2100;
        Assert.assertEquals(1, employees.size());
        Assert.assertEquals(actualSalary, employees.get(0).getSalary().longValue()); }

    @Test
    public void shouldGetSecondMinSalary() throws Exception {
        long maxSalary = Practice.getSecondMinSalary();
        long expectedSalary = 2200;
        Assert.assertEquals(expectedSalary,maxSalary);
    }

    @Test
    public void shouldGetSecondMinSalaryEmployee(){
        List<Employee> employees = Practice.getSecondMinSalaryEmployee();
        long actualSalary = 2200;
        Assert.assertEquals(2, employees.size());
        Assert.assertEquals(actualSalary, employees.get(0).getSalary().longValue());
        Assert.assertEquals(actualSalary, employees.get(1).getSalary().longValue());
    }

    @Test
    public void shouldGetAverageSalary(){
        double averageSalary = Practice.getAverageSalary();
        double expectedAverageSalary = 6461.8317757009345;
        Assert.assertEquals(expectedAverageSalary, averageSalary, DELTA);
    }

    @Test
    public void shouldGetAllEmployeesAboveAverage(){
        List<Employee> employeeList = Practice.getAllEmployeesAboveAverage();
        int expectedEmployeeCount = 51;
        Assert.assertEquals(expectedEmployeeCount, employeeList.size());
    }

    @Test
    public void shouldGetAllEmployeesBelowAverage(){
        List<Employee> employeeList = Practice.getAllEmployeesBelowAverage();
        int expectedEmployeeCount = 56;
        Assert.assertEquals(expectedEmployeeCount, employeeList.size());
    }

    @Test
    public void shouldGetAllEmployeesForEachDepartment() {
        Map<Long, List<Employee>> map = Practice.getAllEmployeesForEachDepartment();
        Assert.assertEquals(35L, map.get(80L).size());
        Assert.assertTrue(map.containsKey(60L));
        Assert.assertEquals(5L, map.get(60L).size());
    }

    @Test
    public void shouldGetTotalDepartmentsNumber(){
        long totalDepartmentsNumber = Practice.getTotalDepartmentsNumber();
        long expectedValue =27;
        Assert.assertEquals(expectedValue, totalDepartmentsNumber);
    }

    @Test
    public void shouldGetEmployeeWhoseFirstNameIsAlyssaAndManagersFirstNameIsEleniAndDepartmentNameIsSales() throws Exception {
        Employee employee = Practice.getEmployeeWhoseFirstNameIsAlyssaAndManagersFirstNameIsEleniAndDepartmentNameIsSales();
        Assert.assertEquals(175L, employee.getId().longValue());
        Assert.assertEquals("Alyssa", employee.getFirstName());
        Assert.assertEquals("Hutton", employee.getLastName());
    }

    @Test
    public void shouldGetAllJobHistoriesInAscendingOrder(){
        List<JobHistory> jobHistoryList = Practice.getAllJobHistoriesInAscendingOrder();
        int expectedValue = 10;
        Assert.assertEquals(expectedValue, jobHistoryList.size());

        LocalDate localDateLast = LocalDate.of(2007,1,1);
        Assert.assertEquals(jobHistoryList.get(9).getStartDate(), localDateLast);

        LocalDate localDateFirst = LocalDate.of(1995,9,17);
        Assert.assertEquals(jobHistoryList.get(0).getStartDate(), localDateFirst);
    }

    @Test
    public void shouldGetAllJobHistoriesInDescendingOrder(){
        List<JobHistory> jobHistoryList = Practice.getAllJobHistoriesInDescendingOrder();
        Assert.assertEquals(10, jobHistoryList.size());

        LocalDate localDateLast = LocalDate.of(2007,1,1);
        Assert.assertEquals(jobHistoryList.get(0).getStartDate(), localDateLast);

        LocalDate localDateFirst = LocalDate.of(1995,9,17);
        Assert.assertEquals(jobHistoryList.get(9).getStartDate(), localDateFirst);
    }

    @Test
    public void shouldGetAllJobHistoriesStartDateAfterFirstDayOfJanuary2005() {
        List<JobHistory> jobHistoryList = Practice.getAllJobHistoriesStartDateAfterFirstDayOfJanuary2005();
        Assert.assertEquals(4, jobHistoryList.size());
    }

    @Test
    public void shouldGetAllJobHistoriesEndDateIsLastDayOfDecember2007AndJobTitleIsProgrammer() {
        List<JobHistory> jobHistoryList = Practice.getAllJobHistoriesEndDateIsLastDayOfDecember2007AndJobTitleIsProgrammer();
        Assert.assertEquals(1, jobHistoryList.size());
    }

    @Test
    public void shouldGetEmployeeOfJobHistoryWhoseStartDateIsFirstDayOfJanuary2007AndEndDateIsLastDayOfDecember2007AndDepartmentNameIsShipping() throws Exception {
        Employee employee = Practice.getEmployeeOfJobHistoryWhoseStartDateIsFirstDayOfJanuary2007AndEndDateIsLastDayOfDecember2007AndDepartmentNameIsShipping();
        Assert.assertEquals("Payam", employee.getFirstName());
        Assert.assertEquals("Kaufling", employee.getLastName());
        Assert.assertEquals(122L,employee.getId().longValue());
    }

    @Test
    public void shouldGetAllEmployeesFirstNameStartsWithA(){
        List<Employee> employees = Practice.getAllEmployeesFirstNameStartsWithA();
        int expectedValue = 10;
        Assert.assertEquals(expectedValue, employees.size());
        for (Employee employee : employees) {
            if (!employee.getFirstName().startsWith("A")) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    Assert.fail();
                }
            }
        }
    }

    @Test
    public void shouldGetAllEmployeesJobIdContainsIT(){
        List<Employee> employees = Practice.getAllEmployeesJobIdContainsIT();
        int expectedValue = 5;
        Assert.assertEquals(expectedValue, employees.size());
        for (Employee employee : employees) {
            if (!employee.getJob().getId().contains("IT")) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    Assert.fail();
                }
            }
        }
    }

    @Test
    public void shouldGetNumberOfEmployeesWhoseJobTitleIsProgrammerAndDepartmentNameIsIT() {
        Long employeeNumber = Practice.getNumberOfEmployeesWhoseJobTitleIsProgrammerAndDepartmentNameIsIT();
        Assert.assertEquals(5L, employeeNumber.longValue());
    }

    @Test
    public void shouldGetAllEmployeesDepartmentIdIs50or80or100(){
        List<Employee> employees = Practice.getAllEmployeesDepartmentIdIs50or80or100();
        int expectedValue = 86;
        Assert.assertEquals(expectedValue, employees.size());
    }

    @Test
    public void shouldGetAllEmployeesInitials(){
        List<String> nameList = Practice.getAllEmployeesInitials();
        List<Employee> employees = Practice.getAllEmployees();

        Assert.assertEquals(
                employees.get(0).getFirstName().substring(0, 1)
                        + employees.get(0).getLastName().substring(0, 1), nameList.get(0));
        Assert.assertEquals(
                employees.get(1).getFirstName().substring(0, 1)
                        + employees.get(1).getLastName().substring(0, 1), nameList.get(1));
        Assert.assertEquals(
                employees.get(employees.size()-1).getFirstName().substring(0, 1)
                        + employees.get(employees.size()-1).getLastName().substring(0, 1), nameList.get(employees.size()-1));
        Assert.assertEquals(
                employees.get(employees.size()-2).getFirstName().substring(0, 1)
                        + employees.get(employees.size()-2).getLastName().substring(0, 1), nameList.get(employees.size()-2));

    }

    @Test
    public void shouldGetAllEmployeesFullNames(){
        List<String> nameList = Practice.getAllEmployeesFullNames();
        List<Employee> employees = Practice.getAllEmployees();

        Assert.assertEquals(
                employees.get(0).getFirstName() + " "
                        + employees.get(0).getLastName(), nameList.get(0));
        Assert.assertEquals(
                employees.get(1).getFirstName() + " "
                        + employees.get(1).getLastName(), nameList.get(1));
        Assert.assertEquals(
                employees.get(employees.size()-1).getFirstName() + " "
                        + employees.get(employees.size()-1).getLastName(), nameList.get(employees.size()-1));
        Assert.assertEquals(
                employees.get(employees.size()-2).getFirstName() + " "
                        + employees.get(employees.size()-2).getLastName(), nameList.get(employees.size()-2));
    }

    @Test
    public void getLongestNameLength() throws Exception {
        int nameLength = Practice.getLongestNameLength();
        int expectedValue = 17;
        Assert.assertEquals(expectedValue,nameLength);
    }

    @Test
    public void shouldGetLongestNameLengthEmployee() {
        List<Employee> employees = Practice.getLongestNamedEmployee();
        int expectedValue = 6;
        Assert.assertEquals(expectedValue,employees.size());
    }

    @Test
    public void shouldGetAllEmployeesDepartmentIdIs90or60or100or120or130(){
        List<Employee> employees = Practice.getAllEmployeesDepartmentIdIs90or60or100or120or130();
        int expectedValue = 14;
        Assert.assertEquals(expectedValue, employees.size());
    }

    @Test
    public void shouldGetAllEmployeesDepartmentIdIsNot90or60or100or120or130(){
        List<Employee> employees = Practice.getAllEmployeesDepartmentIdIsNot90or60or100or120or130();
        int expectedValue = 93;
        Assert.assertEquals(expectedValue, employees.size());
    }

}