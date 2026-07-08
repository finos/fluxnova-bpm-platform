--
-- Copyright 2025 FINOS
--
-- The source files in this repository are made available under the Apache License Version 2.0.
--
-- SPDX-License-Identifier: Apache-2.0
--

alter table ACT_RU_VARIABLE add column if not exists RESTRICTED_ boolean;
alter table ACT_HI_VARINST add column if not exists RESTRICTED_ boolean;
alter table ACT_HI_ATTACHMENT add column if not exists CREATED_BY_ varchar(255);

create index if not exists ACT_IDX_VARIABLE_RESTRICTED on ACT_RU_VARIABLE(RESTRICTED_);
create index if not exists ACT_IDX_HI_VARINST_RESTRICTED on ACT_HI_VARINST(RESTRICTED_);

insert into ACT_GE_SCHEMA_LOG
values ('1500', CURRENT_TIMESTAMP, '3.0.0');
