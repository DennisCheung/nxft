--
-- 家庭设备回收表
--
-- v1.0 2017.06.10
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_dev_recycle_family;
create table  fxp.p_dev_recycle_family (
-- +-----------------------------+--------------+-----------+
   frecycle_id                   varchar2(32)   not null,   -- 回收ID
   --
   -- 用户
   --
   ffamily_id                    varchar2(32)   not null,   -- 家庭ID
   --
   -- 设备详情
   --
   fdevice_id                    varchar2(32)   not null,   -- 设备id
   fdevice_type_id               varchar2(32)   not null,   -- 设备类型ID
   fdevice_type_name             varchar2(50)   not null,   -- 设备类型名称
   fcompany_id                   varchar2(32)   not null,   -- 设备厂商_id
   fcompany_name                 varchar2(30)   not null,   -- 设备厂商_name
   fdevice_model_id              varchar2(32)   not null,   -- 设备型号ID
   fdevice_model_name            varchar2(50)   not null,   -- 设备型号名称
   fdevice_sn                    varchar2(32)   not null,   -- 设备序列号
   fdevice_uuid                  varchar2(32),              -- 设备内部ID
   fproduction_date              date,                      -- 生产日期
   fpurchase_date                date,                      -- 购买日期
   fdevice_Desc                  varchar2(256),             -- 备注
   --
   -- 所属工作圈
   --
   fcircle_id                    varchar2(32),              -- 工作圈id      
   --
   -- 发放
   --
   fissue_date                   date           not null,   -- 发放时间
   fissue_circle_id              varchar2(32)   not null,   -- 发放工作圈id
   fissue_team_id                varchar2(32)   not null,   -- 发放工作组id
   fissue_team_name              varchar2(100)  not null,   -- 发放工作组名称     
   fissue_user_id                varchar2(32)   not null,   -- 发放操作员id
   fissue_nickname               varchar2(40)   not null,   -- 发放操作员姓名
   fissue_desc                   varchar2(256),             -- 发放备注
   --
   -- 回收
   --
   frecycle_date                 date           not null,   -- 回收时间
   frecycle_circle_id            varchar2(32)   not null,   -- 回收工作圈id
   frecycle_team_id              varchar2(32)   not null,   -- 回收工作组id
   frecycle_user_id              varchar2(32)   not null,   -- 回收操作员id
   frecycle_nickname             varchar2(40)   not null,   -- 回收操作员姓名
   frecycle_desc                 varchar2(256),             -- 回收备注    
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
   constraint pk_p_dev_recycle_family primary key (frecycle_id)
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
create index fxp.idx_p_dev_recycle_family_sn on fxp.p_dev_recycle_family (fdevice_sn);
create index fxp.idx_p_dev_recycle_family_fam on fxp.p_dev_recycle_family (ffamily_id);

--
-- 修改历史：
--
