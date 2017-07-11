--
-- 配餐订单表
--
-- v1.0 2017.04.30
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table nxft.nxft_order;
create table  nxft.nxft_order (
-- +-----------------------------+--------------+-----------+
   forder_id                     varchar2(32)   not null,   -- 订单ID
   --
   -- 对象信息
   -- 
   fsubject_id                   varchar2(32)   not null,   -- 对象id   
   fsubject_name                 varchar2(80)   not null,   -- 姓名
   fsex_id                       varchar2(32)   not null,   -- 性别id
   fsex_name                     varchar2(30)   not null,   -- 性别name   
   fcontact_phone                varchar2(30)   not null,   -- 联系电话
   fregion_id                    varchar2(32)   not null,   -- 行政区域ID
   fregion_name                  varchar2(80)   not null,   -- 行政区域名称
   faddress                      varchar2(200),             -- 详细地址
   fsubject_type_id              varchar2(32)   not null,   -- 对象类型id
   fsubject_type_name            varchar2(30)   not null,   -- 对象类型名称
   flunch_box_no                 varchar2(20),              -- 饭盒编号
   fsubject_desc                 varchar2(256),             -- 对象备注
   --
   -- 客户所属
   --
   fcircle_id                    varchar2(32)   not null,   -- 客户所属的工作圈id
   --
   -- 配餐信息
   --
   fdelive_type                  varchar2(30)   not null,   -- 配送方式  助餐点 SITE  到户  HOME
   fdelive_site_id               varchar2(32)   not null,   -- 配送地点id
   fdelive_site_name             varchar2(40)   not null,   -- 配送地点名称
   fdelive_addr                  varchar2(100)  not null,   -- 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name
   fdelive_fee                   number(4,2)    not null,   -- 配送费   
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
   fmeal_id                      varchar2(32)   not null,   -- 套餐id
   fmeal_code                    varchar2(30)   not null,   -- 套餐CODE
   fmeal_name                    varchar2(40)   not null,   -- 套餐名称
   fmeal_content                 varchar2(60)   not null,   -- 套餐内容
   fmeal_price                   number(4,2)    not null,   -- 单价
   fschedule_desc                varchar2(256),             -- 备注
   --
   -- 金额
   --
   fquantity                     number(6,0)    not null,   -- 数量
   fsum_total                    number(10,2)   not null,   -- 金额
   fsum_payment                  number(10,2)   not null,   -- 个人自付金额
   fsum_receivable               number(10,2)   not null,   -- 应收金额
   --
   -- 配送单
   --
   fdelive_note_id               varchar2(32),              -- 配送单id   
   --
   --  新建信息
   --
-- +-----------------------------+--------------+-----------+   
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_user_name             varchar2(50)   not null,   -- 创建操作员姓名
   fcreate_way                   varchar2(20)   not null,   -- 订餐方式  坐席  助餐点
   --
   -- 环节信息
   --
   --
   -- 订单状态  1、 已派单  2、 已接单   4、已配送  5、已发放   6、已取消   
   --
   --
   flast_state                   varchar2(30)   not null,   -- 最后状态，完成时ID
   flast_time                    date           not null,   -- 最新完成时间
   flast_user_id                 varchar2(32)   not null,   -- 最新完成操作员id
   flast_nickname                varchar2(40)   not null,   -- 最新完成操作员name
   flast_desc                    varchar2(256),             -- 流程备注，如为退单，填退单原因。
   --
   -- 下一环节的信息，采用待办作为入口  ACCEPT  接单  DELIVE  配送  GIVE 发放
   --
   fnext_node_id                 varchar2(30),              -- 下一环节 常量，和环节状态、备注同时更新
   fnext_node_content            varchar2(300),             -- 下一环节工作内容
   --
   -- 工单完成信息
   --
   fis_complete                  char(1)        not null,   -- 是否已完成？  Y/N
   fcomplete_state               varchar2(30),              -- 完成状态  SUCCESS  成功  FAIL 失败（取消）
   ffail_reason_name             varchar2(50),              -- 失败原因名称  常量  客户取消
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
   constraint pk_nxft_order primary key (forder_id)
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
