--
-- ���֤�������������֤����
--
-- v1.0 2016.12.19
-- author: alex
--
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_dev_data_idcard;
create table  fxp.p_dev_data_idcard (
-- +-----------------------------+--------------+-----------+
   fdevice_sn                    varchar2(32)   not null,   --  ���֤�������ڲ�ID��
   fperson_name                  varchar2(50)   not null,   --  ��������
   fsex_name                     varchar2(30),              --  �Ա�����
   fnation_name                  varchar2(30),              --  ��������
   fbirth_date                   date           not null,   --  ��������, ����ͨ���������ڼ��������
   fidtype_id                    varchar2(32)   not null,   --  ֤�����  1 ���֤��  2 ��ס֤
   fidtype_name                  varchar2(30)   not null,   --  ���֤����ס֤   
   fid_no                        varchar2(30)   not null,   --  ֤����ţ����֤��
   fregister_addr                varchar2(80),              --  ������ַ
   fissue_org                    varchar2(50),              --  ǩ������
   fvalid_date_start             date,                      --  ��Ч��-��ʼ
   fvalid_date_end               date,                      --  ��Ч��-����                   
   fread_date                    date           not null,   --  ��ȡʱ��
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_dev_idcard primary key (fdevice_sn)   
);

--
-- �ⲿ��Լ��
--
--
-- ����
--
create index fxp.idx_p_dev_data_idcard on fxp.p_dev_data_idcard (fread_date);

