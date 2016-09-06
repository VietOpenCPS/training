create index IX_A4D83042 on LS_Student (firstName);
create index IX_91785721 on LS_Student (studentAge);
create index IX_9B4DB103 on LS_Student (studentGender);
create index IX_EDD1E6BB on LS_Student (studentGender, studentAge);
create unique index IX_7851C4DD on LS_Student (studentId);