--
-- Copyright 2025 FINOS
--
-- The source files in this repository are made available under the Apache License Version 2.0.
--
-- SPDX-License-Identifier: Apache-2.0
--

create table ACT_GE_CONFIGURATION (
                                      ID_          varchar(64)   not null,
                                      CONFIG_KEY_  varchar(255)  not null,
                                      TENANT_ID_   varchar(255),
                                      CONFIG_VALUE_ text         not null,
                                      VERSION_     integer       not null default 1,
                                      STATUS_      varchar(20)   not null default 'ACTIVE',
                                      CREATED_BY_  varchar(255),
                                      CREATED_AT_  timestamp,
                                      UPDATED_BY_  varchar(255),
                                      UPDATED_AT_  timestamp,
                                      primary key (ID_)
);

create unique index ACT_UNIQ_GE_CONFIG_TENANT
    on ACT_GE_CONFIGURATION (CONFIG_KEY_, TENANT_ID_)
    where TENANT_ID_ is not null
      and STATUS_ = 'ACTIVE';

create unique index ACT_UNIQ_GE_CONFIG_GLOBAL
    on ACT_GE_CONFIGURATION (CONFIG_KEY_)
    where TENANT_ID_ is null
      and STATUS_ = 'ACTIVE';

insert into ACT_GE_SCHEMA_LOG
values ('1600', CURRENT_TIMESTAMP, '3.1.0');
