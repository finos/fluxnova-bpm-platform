-- Add CREATED_BY_ column to ACT_HI_ATTACHMENT table
-- This column stores the user who created the attachment
alter table ACT_HI_ATTACHMENT add CREATED_BY_ NVARCHAR2(255);

insert into ACT_GE_SCHEMA_LOG
values ('1310', CURRENT_TIMESTAMP, '1.1.0');
