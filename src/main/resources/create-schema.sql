

CREATE TABLE USERS(
      USERNAME varchar_ignorecase(50) PRIMARY KEY ,
      PASSWORD varchar_ignorecase(250) not null,
      ENABLED boolean not null
);

CREATE TABLE AUTHORITIES (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME varchar_ignorecase(50) not null,
    AUTHORITY varchar_ignorecase(50) not null
--     constraint fk_authorities_users foreign key(USERNAME) references USERS(USERNAME)

  );
CREATE TABLE POST(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CONTENT VARCHAR (148),
  USERNAME varchar_ignorecase(50),
  constraint fk_post_user foreign key(USERNAME) references USERS(USERNAME)
);

CREATE TABLE COMMENT (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CONTENT VARCHAR (148),
  POST_ID INT,
  USERNAME varchar_ignorecase(50),
  constraint fk_comment_post foreign key(POST_ID) references POST(ID),
  constraint fk_comment_user foreign key(USERNAME) references USERS(USERNAME)
);
--  create unique index ix_auth_username on AUTHORITIES (USERNAME,AUTHORITY);
