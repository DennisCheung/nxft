--
-- 收费单表
--
-- v1.0 2016.11.03
-- author：wing
--
-- 说明：
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_chgnote ;
Create Table  fxp.p_chgnote (
-- +-----------------------------+--------------+-----------+
   fchgnote_id                   varchar2(32)   not null,   -- 收费单id
   fchgnote_no                   varchar2(30)   not null,   -- 收费单号
   fchgnote_type                 varchar2(32)   not null,   -- 收费单类型 常量  ORG 机构  PERSON 个人
   --
   -- 创建者
   --
   fcreate_subsys_id             varchar2(32)   not null,   -- 应用子系统id 常量
   fcreate_date                  date           not null,   -- 创建时间
   fcreate_org_id                varchar2(32)   not null,   -- 创建机构id
   fcreate_site_id               varchar2(32)   not null,   -- 创建服务点id
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(30)   not null,   -- 创建操作员姓名
   --
   -- 客户信息
   --
   fperson_id                    varchar2(32),              -- 客户ID， 
   fperson_code                  varchar2(32),              -- 客户编号
   fperson_name                  varchar2(50),              -- 客户姓名
   --
   -- 所属运营商
   --   
   foperator_id                  varchar2(32)   not null,   -- 运营商id
-- +-----------------------------+--------------+-----------+    
   --
   -- 退费控制
   --
   frefund_origin                varchar2(32),              -- 退费原单id
   frefund_reverse               varchar2(32),              -- 退费负单id
   frefund_id                    varchar2(32),              -- 退费正单id
   --
   -- 金额
   --
   fsum_total                    number(10, 2)  not null,   -- 总金额（=计价金额）
   fsum_discounted               number(10, 2)  not null,   -- 折扣金额(优惠金额)
   fsum_payment                  number(10, 2)  not null,   -- 个人自付金额 = 总金额 - 折扣金额   
   fsum_own                      number(10, 2)  not null,   -- 自费金额
   fsum_coupon                   number(10, 2)  not null,   -- 券的金额
   --
   -- 缴款报表
   --
   fcsreport_id                  varchar2(32)   default 'NONE' -- 缴款报表ID(未缴款写入'NONE')
                                                not null,
   fcsreport_date                date           not null,      -- 缴款日期(未缴款写入10年后日期)
   --
   fchgnote_desc                 varchar2(256),                -- 备注   
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
   constraint pk_p_chgnote primary key (fchgnote_id),
   constraint uk_p_chgnote_no unique (fchgnote_no)
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
create index fxp.idx_p_chgnote_date     on fxp.p_chgnote(fcreate_date);
create index fxp.idx_p_chgnote_person   on fxp.p_chgnote(fperson_id);
create index fxp.idx_p_chgnote_csreport on fxp.p_chgnote(fcsreport_id);
create index fxp.idx_p_chgnote_csredate on fxp.p_chgnote(fcsreport_date);