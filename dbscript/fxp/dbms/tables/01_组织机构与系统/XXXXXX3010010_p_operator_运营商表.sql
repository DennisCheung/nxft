--
-- 运营商表，相当于机构表的扩展
--
-- v1.0 2016.08.09
-- author：wing
--
-- 机构表中运营商属性扩展  。
-- 修改历史：
--
--
--
-- Drop Table fxp.p_operator;
Create Table  fxp.p_operator (
-- +-----------------------------+--------------+-----------+
   foperator_id                  varchar2(32)   not null,   -- 运营商id
   foperator_name                varchar2(50)   not null,   -- 运营商名称
   -- foperator_fullname         varchar2(100)  not null,   -- 运营商全称
   foperator_info                varchar2(1000),            -- 运营商简介
   fregion_id                    varchar2(32)   not null,   -- 行政区域ID
   fregion_name                  varchar2(80)   not null,   -- 行政区域名称    
   --
   faddress                      varchar2(200),             -- 详细地址
   foperator_desc                varchar2(256),             -- 备注 
   --
   -- 合同信息
   -- 
   -- fpersons_max               number(8)   default 0   not null, -- 最大客户数
   -- fseats_max                 number(8)   default 0   not null, -- 最大坐席数
   -- fcontract_begin_date       date           not null,    -- 合同开始时间
   -- fcontract_end_date         date           not null,    -- 合同结束时间      
   --
   -- 联系人
   --
   fcontact_person               varchar2(30),              -- 联系人姓名
   -- fcontact_duty              varchar2(30),              -- 联系人职位
   fcontact_mobile               varchar2(30),              -- 联系人手机
   fcontact_email                varchar2(30),              -- 联系人邮箱
   fdefault_region_id            varchar2(32),              -- 默认行政区域ID
   fdefault_region_name          varchar2(80),              -- 默认行政区域名称 
-- +-----------------------------+--------------+-----------+
   --
   -- 开通
   --
   fcreate_date                  date default sysdate not null, -- 创建日期（录入时输入的日期） 
   fcreate_user_id               varchar2(32)  not null,   -- 创建操作员id
   fcreate_user_name             varchar2(50)  not null,   -- 创建操作员姓名
   --
   -- 注销
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   fcancel_reason                varchar2(60),              -- 注销原因
   fcancel_date                  date,                      -- 注销机器时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id   
   fcancel_user_name             varchar2(30),              -- 注销操作员姓名      
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
   constraint pk_p_operator primary key (foperator_id)
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

insert into p_operator (Foperator_ID, Foperator_NAME, Foperator_FULLNAME, Foperator_INFO, FREGION_ID, FREGION_NAME, FADDRESS, Foperator_DESC, FPERSONS_MAX, FSEATS_MAX, FCONTRACT_BEGIN_DATE, FCONTRACT_END_DATE, FCONTACT_PERSON, FCONTACT_DUTY, FCONTACT_MOBILE, FCONTACT_EMAIL, FCREATE_DATE, FCREATE_USER_ID, FCREATE_USER_NAME, FIS_CANCEL, FCANCEL_REASON, FCANCEL_DATE, FCANCEL_USER_ID, FCANCEL_USER_NAME, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10001', '广州福来', '广州福来健康管理有限公司', '', '2951', '广东省广州市', '', '', 9999, 999, to_date('19-08-2015', 'dd-mm-yyyy'), to_date('19-08-2020', 'dd-mm-yyyy'), '', '', '', '', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', 'admin', 'N', '', null, '', '', 0, 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'));

insert into p_operator (Foperator_ID, Foperator_NAME, Foperator_FULLNAME, Foperator_INFO, FREGION_ID, FREGION_NAME, FADDRESS, Foperator_DESC, FPERSONS_MAX, FSEATS_MAX, FCONTRACT_BEGIN_DATE, FCONTRACT_END_DATE, FCONTACT_PERSON, FCONTACT_DUTY, FCONTACT_MOBILE, FCONTACT_EMAIL, FCREATE_DATE, FCREATE_USER_ID, FCREATE_USER_NAME, FIS_CANCEL, FCANCEL_REASON, FCANCEL_DATE, FCANCEL_USER_ID, FCANCEL_USER_NAME, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10002', '顺德福来', '顺德福来健康管理有限公司', '', '2994', '广东省佛山市顺德区', '', '', 9999, 999, to_date('19-08-2015', 'dd-mm-yyyy'), to_date('19-08-2020', 'dd-mm-yyyy'), '', '', '', '', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', 'admin', 'N', '', null, '', '', 0, 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'));

insert into p_operator (Foperator_ID, Foperator_NAME, Foperator_FULLNAME, Foperator_INFO, FREGION_ID, FREGION_NAME, FADDRESS, Foperator_DESC, FPERSONS_MAX, FSEATS_MAX, FCONTRACT_BEGIN_DATE, FCONTRACT_END_DATE, FCONTACT_PERSON, FCONTACT_DUTY, FCONTACT_MOBILE, FCONTACT_EMAIL, FCREATE_DATE, FCREATE_USER_ID, FCREATE_USER_NAME, FIS_CANCEL, FCANCEL_REASON, FCANCEL_DATE, FCANCEL_USER_ID, FCANCEL_USER_NAME, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10003', '三水福来', '三水福来健康管理有限公司', '', '4392', '广东省佛山市三水区', '', '', 9999, 999, to_date('19-08-2015', 'dd-mm-yyyy'), to_date('19-08-2020', 'dd-mm-yyyy'), '', '', '', '', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', 'admin', 'N', '', null, '', '', 0, 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'));

commit;

