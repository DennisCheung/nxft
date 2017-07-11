--
-- �û����λ�ñ�
--
-- v1.0 2016.11.10
-- author��wing
--
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_user_location;
create table  fxp.p_user_location (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�id
   frec_time                     date           not null,   -- ��¼ʱ��         
   --
   --  λ������
   --
   flocation_time                date           not null,   -- ��λʱ��   
   fcity                         varchar2(16),              -- ����
   faddress                      varchar2(128),             -- ��ַ
   flongitude                    number(19,15)   not null,   -- ����
   flatitude                     number(19,15)   not null,   -- γ��
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
   constraint pk_p_user_location primary key (fuser_id)
);

--
-- �ⲿ��Լ��
--
--
-- ����
--


