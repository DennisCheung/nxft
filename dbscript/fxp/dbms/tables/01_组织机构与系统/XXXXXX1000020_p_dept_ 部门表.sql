--
-- ���ű�
--
-- v1.0 2015.08.13
-- author��wing
--
-- ˵����
-- 1���ɻ�������Ա���и��ݸ�������ʵ���������
--
--
--
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_dept;
Create Table  fxp.p_dept (
-- +-----------------------------+--------------+-----------+
   fdept_id                      varchar2(32)   not null,   -- ����id��Ϊ��΢����ҵ�ż��ݣ������ֿ�ͷ����ϵͳ�Զ�����
   fdept_name                    varchar2(50)   not null,   -- ������������
   forg_id                       varchar2(32)   not null,   -- ��������id
   fdept_desc                    varchar2(256),             -- ��ע
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
   constraint pk_p_dept primary key (fdept_id),
   constraint uk_p_dept_org unique (forg_id,fdept_id)
);

--
-- ͬ���
--
--
-- ��Ȩ
--
grant all on fxp.p_dept to sf,hbcs;
--
-- ����
--


--
-- �޸���䣺
--
