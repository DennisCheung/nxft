--
-- ��������ָ����
--
-- v1.0 2015.06.11
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_disease_guide;
create table  fxp.p_disease_guide (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- ����ID
   --
   -- ָ������
   --
   ffood_guide                   varchar2(2000),            -- ��ʳָ��
   fsports_guide                 varchar2(2000),            -- �˶�ָ��
   fpsych_guide                  varchar2(2000),            -- ����ָ��
   fsleep_guide                  varchar2(2000),            -- ˯��ָ��
   fmedicine_guide               varchar2(2000),            -- ��ҩָ��
   fother_guide                  varchar2(2000),            -- ����ָ��
   fdesc                         varchar2(256),             -- ��ע
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
   constraint pk_p_disease_guide primary key (fdisease_id)
);

--
-- ͬ���
--
