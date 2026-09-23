--
-- Copyright 2025 FINOS
--
-- The source files in this repository are made available under the Apache License Version 2.0.
--
-- SPDX-License-Identifier: Apache-2.0
--

create table ACT_GE_CONFIGURATION (
                                      ID_          VARCHAR2(64)   not null,
                                      CONFIG_KEY_  VARCHAR2(255)  not null,
                                      TENANT_ID_   VARCHAR2(255),
                                      CONFIG_VALUE_ CLOB          not null,
                                      VERSION_     INTEGER        default 1 not null,
                                      STATUS_      VARCHAR2(20)   default 'ACTIVE' not null,
                                      CREATED_BY_  VARCHAR2(255),
                                      CREATED_AT_  TIMESTAMP,
                                      UPDATED_BY_  VARCHAR2(255),
                                      UPDATED_AT_  TIMESTAMP,
                                      constraint PK_ACT_GE_CONFIGURATION primary key (ID_)
);

create unique index ACT_UNIQ_GE_CONFIG
    on ACT_GE_CONFIGURATION (CONFIG_KEY_, case when TENANT_ID_ is null then 1 else 0 end, NVL(TENANT_ID_, ' '),
                             case when STATUS_ = 'ACTIVE' then 'ACTIVE' else ID_ end);

insert into ACT_GE_SCHEMA_LOG
values ('1600', CURRENT_TIMESTAMP, '3.1.0');
