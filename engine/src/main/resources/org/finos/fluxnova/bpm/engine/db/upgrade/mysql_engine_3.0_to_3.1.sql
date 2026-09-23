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
                                      TENANT_ID_NULL_ integer generated always as (case when TENANT_ID_ is null then 1 else 0 end) stored,
                                      TENANT_ID_UNIQUE_ varchar(255) generated always as (coalesce(TENANT_ID_, '')) stored,
                                      CONFIG_VALUE_ longtext     not null,
                                      VERSION_     integer       not null default 1,
                                      STATUS_      varchar(20)   not null default 'ACTIVE',
                                      ACTIVE_SCOPE_UNIQUE_ varchar(64) generated always as (case when STATUS_ = 'ACTIVE' then 'ACTIVE' else ID_ end) stored,
                                      CREATED_BY_  varchar(255),
                                      CREATED_AT_  datetime(3),
                                      UPDATED_BY_  varchar(255),
                                      UPDATED_AT_  datetime(3),
                                      primary key (ID_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

create unique index ACT_UNIQ_GE_CONFIG
    on ACT_GE_CONFIGURATION (CONFIG_KEY_, TENANT_ID_NULL_, TENANT_ID_UNIQUE_, ACTIVE_SCOPE_UNIQUE_);


insert into ACT_GE_SCHEMA_LOG
values ('1600', CURRENT_TIMESTAMP, '3.1.0');
