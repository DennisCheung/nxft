--
-- 亲朋联系人表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_person_contacts;
create table  fxp.p_person_contacts (
-- +-----------------------------+--------------+-----------+
   fcontact_id                   varchar2(32)   not null,   -- 联系人id
   fcontact_name                 varchar2(40)   not null,   -- 联系人姓名
   --
   fperson_id                    varchar2(32)   not null,   -- 居民ID， 
   fperson_relation_id           varchar2(32)   not null,   -- 客户亲朋关系ID
   fperson_relation_name         varchar2(30)   not null,   -- 客户亲朋关系name
   fregion_id                    varchar2(32),              -- 行政区域ID（其中包含省、市、区、街道、社区的各级编码）
   fregion_name                  varchar2(80),              -- 行政区域名称
   faddress                      varchar2(200),             -- 详细地址（街道之后的详细地址）    
   ffixPhone                     varchar2(40),              -- 固定电话
   fmobile                       varchar2(40),              -- 手机
   fis_emergency                 char(1)        not null,   -- 是否紧急联系人 Y/N
   fordernum                     number(6,2)    not null,   -- 排序号
   fcontact_desc                varchar2(256),              -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
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
   constraint pk_p_person_contacts primary key (fcontact_id),
   constraint uk_p_person_contacts unique (fperson_id,fcontact_name)
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

--
-- 修改历史：
--
