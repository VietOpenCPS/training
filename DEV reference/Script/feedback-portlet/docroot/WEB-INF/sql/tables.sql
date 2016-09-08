create table opencps_feedback (
	feedbackId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fullName VARCHAR(75) null,
	email VARCHAR(75) null,
	feedBack VARCHAR(75) null
);