--
-- 配送单表
--
-- v1.0 2017.03.04
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table nxft.delive_note;
create table  nxft.delive_note (
-- +-----------------------------+--------------+-----------+
   fdelive_note_id               varchar2(32)   not null,   -- 配送单ID
   --
   -- 客户所属
   --
   fcircle_id                    varchar2(32)   not null,   -- 客户所属的工作圈id
   --
   -- 配餐信息
   --
   fdelive_type                  varchar2(30)   not null,   -- 配送方式  助餐点 SITE  到户上门  HOME
   fdelive_site_id               varchar2(32)   not null,   -- 配送地点id
   fdelive_site_name             varchar2(40)   not null,   -- 配送地点名称
   fdelive_addr                  varchar2(100)  not null,   -- 配送地址  = fxp.p_team.faddress  
   fcontact_person               varchar2(30),              -- 联系人
   fcontact_mobile               varchar2(30),              -- 联系手机   
   --
   -- 厨房
   --
   fkitchen_circle_id            varchar2(32)   not null,   -- 厨房圈id
   fkitchen_team_id              varchar2(32)   not null,   -- 厨房teamid
   --
   -- 排班
   --
   fmeal_date                    date           not null,   -- 就餐日期
   fweek                         number(1)      not null,   -- 周几
   fmeal_type_id                 varchar2(32)   not null,   -- 餐别ID
   fmeal_type_name               varchar2(40)   not null,   -- 餐别名称
   --
   -- 数量
   --
   fquantity                     number(6,0)    not null,   -- 数量
   fquantity_desc               varchar2(300)   not null,   -- 数量描述
   --
   --  新建信息
   --
-- +-----------------------------+--------------+-----------+   
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_user_name             varchar2(50)   not null,   -- 创建操作员姓名
   --
   -- 环节信息
   --
   --
   -- 订单状态  1、 已接单     2、已配送   3、已送达
   --
   --
   flast_state                   varchar2(30)   not null,   -- 最后状态，完成时ID
   flast_time                    date           not null,   -- 最新完成时间
   flast_user_id                 varchar2(32)   not null,   -- 最新完成操作员id
   flast_nickname                varchar2(40)   not null,   -- 最新完成操作员name
   flast_desc                    varchar2(256),             -- 流程备注，如为退单，填退单原因。
   --
   -- 下一环节的信息，采用待办作为入口  DELIVE  配送  ARRIVE  送达
   --
   fnext_node_id                 varchar2(30),              -- 下一环节 常量，和环节状态、备注同时更新
   fnext_node_content            varchar2(300),             -- 下一环节工作内容
   --
   -- 工单完成信息
   --
   fis_complete                  char(1)        not null,   -- 是否已完成？  Y/N
   fcomplete_state               varchar2(30),              -- 完成状态  SUCCESS  成功  FAIL 失败（取消）
   ffail_reason_name             varchar2(50),              -- 失败原因名称  常量  客户取消、改派
   fcomplete_time                date,                      -- 完成时间
   fcomplete_user_id             varchar2(32),              -- 完成操作员工号id
   fcomplete_nickname            varchar2(30),              -- 完成操作员姓名
   fcomplete_desc                varchar2(256),             -- 完成备注   
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
   constraint pk_delive_note primary key (fdelive_note_id)
   --
   -- 约束
   --
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
-- 修改语句
--
