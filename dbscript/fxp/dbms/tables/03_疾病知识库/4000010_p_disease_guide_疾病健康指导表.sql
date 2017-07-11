--
-- 疾病健康指导表
--
-- v1.0 2015.06.11
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_disease_guide;
create table  fxp.p_disease_guide (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- 疾病ID
   --
   -- 指导内容
   --
   ffood_guide                   varchar2(2000),            -- 饮食指导
   fsports_guide                 varchar2(2000),            -- 运动指导
   fpsych_guide                  varchar2(2000),            -- 心理指导
   fsleep_guide                  varchar2(2000),            -- 睡眠指导
   fmedicine_guide               varchar2(2000),            -- 服药指导
   fother_guide                  varchar2(2000),            -- 其他指导
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
   constraint pk_p_disease_guide primary key (fdisease_id)
);

--
-- 同义词
--
