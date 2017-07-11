--
-- 身份证读卡器最新身份证数据
--
-- v1.0 2016.12.19
-- author: alex
--
--
-- 修改历史：
--
--
--
-- drop table fxp.p_dev_data_idcard;
create table  fxp.p_dev_data_idcard (
-- +-----------------------------+--------------+-----------+
   fdevice_sn                    varchar2(32)   not null,   --  身份证读卡器内部ID号
   fperson_name                  varchar2(50)   not null,   --  居民姓名
   fsex_name                     varchar2(30),              --  性别中文
   fnation_name                  varchar2(30),              --  民族中文
   fbirth_date                   date           not null,   --  出生日期, 年龄通过出生日期计算出来。
   fidtype_id                    varchar2(32)   not null,   --  证件类别  1 身份证号  2 居住证
   fidtype_name                  varchar2(30)   not null,   --  身份证、居住证   
   fid_no                        varchar2(30)   not null,   --  证件编号（身份证）
   fregister_addr                varchar2(80),              --  户籍地址
   fissue_org                    varchar2(50),              --  签发机关
   fvalid_date_start             date,                      --  有效期-起始
   fvalid_date_end               date,                      --  有效期-结束                   
   fread_date                    date           not null,   --  读取时间
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
   constraint pk_p_dev_idcard primary key (fdevice_sn)   
);

--
-- 外部键约束
--
--
-- 索引
--
create index fxp.idx_p_dev_data_idcard on fxp.p_dev_data_idcard (fread_date);

