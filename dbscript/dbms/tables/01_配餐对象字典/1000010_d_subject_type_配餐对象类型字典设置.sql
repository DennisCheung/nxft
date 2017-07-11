--
-- 配餐对象类型字典设置
--
-- v1.0 2017.03.27
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table nxft.d_subject_type;
create table  nxft.d_subject_type (
-- +-----------------------------+--------------+-----------+
   fsubject_type_id              varchar2(32)   not null,   -- 对象类型id
   fsubject_type_code            varchar2(30)   not null,   -- 对象类型CODE
   fsubject_type_name            varchar2(40)   not null,   -- 对象类型名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fsubject_type_desc            varchar2(256),             -- 备注
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
   constraint pk_d_subject_type primary key (fsubject_type_id),
   constraint uk_d_subject_type_code unique (fsubject_type_code)
);

--
-- 同义词
--

--
-- 索引
--
