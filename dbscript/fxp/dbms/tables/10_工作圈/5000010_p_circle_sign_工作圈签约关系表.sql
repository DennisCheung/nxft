--
-- 工作圈签约关系表
--
-- v1.0 2017.02.13
-- author：wing
--
-- 
-- 修改历史：
--
--
--
-- Drop Table fxp.p_circle_sign;
Create Table  fxp.p_circle_sign (
-- +-----------------------------+--------------+-----------+
   fsign_id                      varchar2(32)   not null,   -- 签约id
   fprovider_circle_id           varchar2(32)   not null,   -- 提供服务工作圈id
   fcustomer_circle_id           varchar2(32)   not null,   -- 客户方工作圈id
   fbusiness_id                  varchar2(32)   not null,   -- 业务id
   fsign_desc                    varchar2(256),             -- 备注 
-- +-----------------------------+--------------+-----------+
   --
   -- 创建者
   --
   fcreate_time                  date default sysdate not null, -- 创建时间 
   fcreate_user_id               varchar2(32)  not null,   -- 创建操作员id
   fcreate_user_name             varchar2(50)  not null,   -- 创建操作员姓名
-- +-----------------------------+--------------+-----------+
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
   constraint pk_p_circle_sign primary key (fsign_id),
   constraint uk_p_circle_sign unique (fprovider_circle_id,fcustomer_circle_id,fbusiness_id)
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
-- 修改语句：
--
