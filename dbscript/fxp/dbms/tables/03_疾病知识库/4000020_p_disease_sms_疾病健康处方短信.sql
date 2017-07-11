--
-- 疾病健康处方短信表
--
-- v1.0 2015.11.11
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_disease_sms;
create table  fxp.p_disease_sms (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- 疾病ID
   --
   -- 指导内容
   --
   fguide_sms                    varchar2(2000) not null,   -- 健康指导短信
   fdesc                         varchar2(256),             -- 备注
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
   constraint pk_p_disease_sms primary key (fdisease_id)
);

--
-- 同义词
--
