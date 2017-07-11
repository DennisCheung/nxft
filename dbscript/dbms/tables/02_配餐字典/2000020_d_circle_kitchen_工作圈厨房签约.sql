--
-- 工作圈厨房签约
--
-- v1.0 2017.04.29
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table nxft.d_circle_kitchen;
create table  nxft.d_circle_kitchen (
-- +-----------------------------+--------------+-----------+
   fsign_id                      varchar2(32)   not null,   -- 签约id
   fcircle_id                    varchar2(32)   not null,   -- 所属的工作圈id
   fkitchen_circle_id            varchar2(32)   not null,   -- 厨房圈id
   fkitchen_team_id              varchar2(32)   not null,   -- 厨房teamid
   fdelive_fee                   number(4,2)    not null,   -- 配送费
   fkitchen_desc                 varchar2(256),             -- 备注
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
   constraint pk_d_circle_kitchen primary key (fsign_id),
   constraint uk_d_circle_kitchen unique (fcircle_id,fkitchen_team_id)
);

--
-- 同义词
--

--
-- 索引
--
