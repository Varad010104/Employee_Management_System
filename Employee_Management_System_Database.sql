create database EmployeeManagementSystem;
use EmployeeManagementSystem;
create table Admin(admin_id INT PRIMARY KEY AUTO_INCREMENT, 
								username varchar(50) not null unique,
                                userPassword varchar(200) not null,
                                contact_no varchar(15),
                                email varchar(100) not null
);
select * from Admin;

create table EmployeeTable(emp_id varchar(50) primary key,
						   emp_first_name varchar(50) not null unique,
                           emp_last_name varchar(50) not null,
                           emp_date_of_birth varchar(50),
                           emp_contact_no varchar(15),
                           emp_email varchar(100) not null,
                           emp_salary varchar(100) not null,
                           emp_address varchar(100),
                           emp_designation varchar(70) not null,
                           emp_education varchar(50)
);

select * from EmployeeTable;