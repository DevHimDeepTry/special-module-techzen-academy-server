-- Create department table first
CREATE TABLE department
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)       NULL,
    CONSTRAINT pk_department PRIMARY KEY (id)
);

-- Create employee table next (it references department)
CREATE TABLE employee
(
    id            INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)       NULL,
    dob           DATE               NULL,
    gender        VARCHAR(255)       NULL,
    salary        DOUBLE             NULL,
    phone         VARCHAR(255)       NULL,
    department_id INT                NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

-- Add foreign key to employee table for department
ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department (id);

-- Create department_employees table (it references both department and employee)
CREATE TABLE department_employees
(
    department_id INT NOT NULL,
    employees_id  INT NOT NULL,
    CONSTRAINT uc_department_employees_employees UNIQUE (employees_id),
    CONSTRAINT fk_depemp_on_department FOREIGN KEY (department_id) REFERENCES department (id),
    CONSTRAINT fk_depemp_on_employee FOREIGN KEY (employees_id) REFERENCES employee (id)
);

-- Create student table
CREATE TABLE student
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)       NULL,
    score INT                NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);
