create database if not exists jdbcdemo;
use jdbcdemo;

create table employees(
                          id int auto_increment primary key,
                          name varchar(255) not null,
                          salary decimal(18,2)
);

create table address(
                        id int auto_increment primary key,
                        address_one varchar(255) not null,
                        address_two varchar(255),
                        city varchar(50) not null,
                        zipcode int(5) not null
);

alter table address add column emp_id int not null;

alter table address add constraint fk_employee_address
    foreign key(emp_id) references employees(id);


insert into employees (name, salary) values
                                         ('John Doe', 50000.0),
                                         ('Jane Doe', 60000.0),
                                         ('Jafer Alhaboubi', 70000.0);


insert into address (address_one,address_two,city,zipcode,emp_id) values
                                                                      ('123 st', null, 'Dallas', 75555,1),
                                                                      ('456 st', null, 'Las Vegas', 89100,2),
                                                                      ('789 st', null, 'Los Angeles', 92000,2),
                                                                      ('222 st', null, 'Plano', 75000,3);




describe employees;
describe address;

select * from address;
select * from employees;



select * from
    employees as e
        join address as a on e.id = a.emp_id
where e.id in (select e.id
               from employees as e
                        join address as a on e.id = a.emp_id
               group by e.id
               having count(e.id) > 1);

