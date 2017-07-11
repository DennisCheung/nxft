--
-- 活动名单表
--
--
-- v1.0 2016.08.30
-- author：wing
--
-- 说明：
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_activity_crowds ;
Create Table  fxp.p_activity_crowds (
-- +-----------------------------+--------------+-----------+
   fcrowds_id                    varchar2(32)   not null,   -- 名单id
   fcrowds_name                  varchar2(100)  not null,   -- 名单名称    
   fcrowds_desc                  varchar2(256),             -- 备注
   --
   -- 所属的活动
   --
   factivity_id                  varchar2(32)   not null,   -- 活动id   
   --
   -- 所属运营商
   --
   foperator_id                  varchar2(32)   not null,   -- 运营商id    
   --
   -- 创建
   --
   fcreate_date                  date           not null,   -- 创建时间  
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(30)   not null,   -- 创建操作员姓名      
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
   constraint pk_p_activity_crowds primary key (fcrowds_id)
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


