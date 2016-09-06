create table LS_Student (
	studentId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	studentAge INTEGER,
	studentGender INTEGER,
	studentAddress VARCHAR(75) null
);