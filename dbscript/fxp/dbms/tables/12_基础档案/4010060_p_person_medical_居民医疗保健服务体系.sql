--
-- 居民医疗保健服务体系
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_person_medical;
create table  fxp.p_person_medical (
-- +-----------------------------+--------------+-----------+
   fregister_id                  varchar2(32)   not null,   -- 登记id
   fperson_id                    varchar2(32)   not null,   -- 居民ID，
   --
   fhospital_name                varchar2(60),              -- 医疗机构名称
   fdoctor_name                  varchar2(40),              -- 医生姓名
   fcontact_phone                varchar2(40),              -- 联系电话
   fmedical_item                 varchar2(80),              -- 常看疾病/保健项目 
   fmedical_treatment_id         varchar2(32),              -- 医疗待遇id
   fmedical_treatment_name       varchar2(30),              -- 医疗待遇名称
   --
   fordernum                     number(6,2)    not null,   -- 排序号
   fregister_desc                varchar2(256),             -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_person_medical primary key (fregister_id)
);

--
-- 同义词
--


--
-- 授权
--


--
-- 索引
--
create index idx_file_person_medical1 on fxp.file_person_medical(fperson_id);

--
-- 修改历史：
--
