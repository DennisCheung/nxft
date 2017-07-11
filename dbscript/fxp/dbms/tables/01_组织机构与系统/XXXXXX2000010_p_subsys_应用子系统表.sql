--
-- 应用子系统表
--
-- v1.0 2015.05.31
-- author：wing
--
-- 修改历史：
--
-- drop table fxp.p_subsys;
create table  fxp.p_subsys (
-- +-----------------------------+--------------+-----------+
   fsubsys_id                    varchar2(32)   not null,   -- 应用子系统id 常量
   fsubsys_name                  varchar2(60)   not null,   -- 应用子系统名称
   fsubsys_url                   varchar2(200)  not null,   -- 应用子系统主页相对地址
   fis_open_pc                   char(1)        not null,   -- 是否开通PC端应用  Y/N
   fis_open_wechat               char(1)        not null,   -- 是否开通微信端应用 Y/N
   fsubsys_desc                  varchar2(256),             -- 描述
-- +-----------------------------+--------------+-----------+
   fordernum                     number(6,2)    not null,   -- 排序号
   fversion                      number(6)      not null,   -- 版本号
   --
   -- 主键、唯一键
   --
   constraint pk_p_subsys primary key (fsubsys_id),
   constraint uk_p_subsys unique (fsubsys_name)
   --
   -- 约束
   --
);

--
-- 授权
--
grant all on fxp.p_subsys to sf,hbcs;
--
-- 索引
--

--
-- 修改语句
--

insert into p_subsys (FSUBSYS_ID, FSUBSYS_NAME, FSUBSYS_URL, FSUBSYS_DESC, FORDERNUM, FVERSION)
values ('SF', '回访子系统', 'http://localhost:8080/v/sf', '', 1.00, 0);



commit;
