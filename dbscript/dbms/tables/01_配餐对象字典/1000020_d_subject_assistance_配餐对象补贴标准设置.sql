--
-- 配餐对象补贴标准设置
--
-- v1.0 2017.03.27
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table nxft.d_subject_assistance;
create table  nxft.d_subject_assistance (
-- +-----------------------------+--------------+-----------+
   fassistance_id                varchar2(32)   not null,   -- 补助id
   fcircle_id                    varchar2(32)   not null,   -- 客户所属的工作圈id
   fsubject_type_id              varchar2(32)   not null,   -- 对象类型ID
   fmeal_type_id                 varchar2(32)   not null,   -- 餐别类型id
   fassistance_model             varchar2(30)   not null,   -- 补助模式 RADIO 比例  FEE 金额
   fassistance_ratio             number(3,2),               -- 补助比例
   fassistance_fee               number(6,2),               -- 补助金额
   fassistance_desc              varchar2(256),             -- 备注
-- +-----------------------------+--------------+-----------+
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
   constraint pk_d_subject_assistance primary key (fassistance_id),
   constraint uk_d_subject_assistance unique (fcircle_id,fsubject_type_id,fmeal_type_id)
);

--
-- 同义词
--

--
-- 索引
--
