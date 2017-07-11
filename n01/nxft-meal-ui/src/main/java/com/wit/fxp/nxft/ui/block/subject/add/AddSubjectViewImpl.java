package com.wit.fxp.nxft.ui.block.subject.add;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.datatype.IdAndName;
import com.wit.fxp.converter.ObjectToBooleanConverter;
import com.wit.fxp.nxft.app.command.AddSubjectCommand;
import com.wit.fxp.nxft.ui.components.DoubleField;
import com.wit.fxp.nxft.ui.components.WCheckBox;
import com.wit.fxp.nxft.ui.components.WNativeSelect;
import com.wit.fxp.nxft.ui.components.WRadioButton;
import com.wit.fxp.nxft.utils.StringUtils;
import com.wit.fxp.ui.regionalism.RegionalismPresenter;
import com.wit.fxp.ui.utils.FieldUtils;
import com.wit.fxp.vaadin.server.data.fieldgroup.FxpBeanFieldGroup;

@PrototypeScope
@SpringView(name = AddSubjectView.NAME)
public class AddSubjectViewImpl extends Window implements AddSubjectView, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout hor1 = new HorizontalLayout();
    private final Label lbtitle = new Label("客户信息——新增");

    private final HorizontalLayout hor2 = new HorizontalLayout();
    private final Label xin1 = new Label("*");
    private final Label lbname = new Label("姓名：");
    private final TextField name = new TextField();
    private final Label xin2 = new Label("*");
    private final Label lbsubjectType = new Label("对象类型：");
    private final WNativeSelect subjectType = new WNativeSelect();

    private final HorizontalLayout hor3 = new HorizontalLayout();
    private final Label xin3 = new Label("*");
    private final Label lbno = new Label("身份证号：");
    private final TextField idNo = new TextField();
    private final Label xin4 = new Label("*");
    private final Label lbphone = new Label("联系电话：");
    private final TextField phone = new TextField();

    private final HorizontalLayout hor4 = new HorizontalLayout();
    private final Label xin2ll = new Label("*");
    private final Label lbreg = new Label("所在地区：");

    private final HorizontalLayout hor5 = new HorizontalLayout();

    private final HorizontalLayout hordis = new HorizontalLayout();
    private final Label lbdisease = new Label("常见疾病：");
    private final WCheckBox diseases = new WCheckBox();
    private final HorizontalLayout horibtf = new HorizontalLayout();
    private final TextField jbtf = new TextField();

    private final HorizontalLayout hor55 = new HorizontalLayout();
    private final Label xin5 = new Label("*");
    private final Label lbeee = new Label("透支额度：");
    private final DoubleField overDraft = new DoubleField();
    private final Label yuan = new Label("元");
    private final Label xin33 = new Label("*");
    private final Label lbaddress = new Label("详细地址：");
    private final TextField address = new TextField();

    private final HorizontalLayout hor6 = new HorizontalLayout();
    private final Label xin6 = new Label("*");
    private final Label lbsdtype = new Label("配送方式：");
    private final WNativeSelect sendType = new WNativeSelect();
    private final Label xin7 = new Label("*");
    private final Label lbzcd = new Label("助餐点：");
    private final WNativeSelect mealSite = new WNativeSelect();

    private final HorizontalLayout hor66 = new HorizontalLayout();
    private final Label lb666 = new Label("饮食偏好：");
    private final WNativeSelect subjectFoodLove = new WNativeSelect();
    private final Label lb676 = new Label("是否协助：");
    private final WRadioButton isMealHelp = new WRadioButton();

    private final HorizontalLayout hor7 = new HorizontalLayout();
    private final Label lbdesc = new Label("备注：");
    private final TextField desc = new TextField();

    private final HorizontalLayout hor8 = new HorizontalLayout();
    private final Label lbjinji = new Label("紧急联系人：");
    private final TextField jinjiName = new TextField();
    private final Label jjphone = new Label("联系电话：");
    private final TextField jinjiPhone = new TextField();
    private final Label jjlb = new Label("关系：");
    private final WNativeSelect wnjinji = new WNativeSelect();

    private final HorizontalLayout hor9 = new HorizontalLayout();
    private final Button btn1 = new Button("取消");
    private final Button btn2 = new Button("保存");

    private final HorizontalLayout hor10 = new HorizontalLayout();
    private final Label lb10 = new Label("户籍所在地：");
    private final WRadioButton wrahuji = new WRadioButton();

    private final HorizontalLayout horlll = new HorizontalLayout();
    private final Label fhlb = new Label("饭盒编号：");
    private final TextField lunchBoxNo = new TextField();

    private final HorizontalLayout hor11 = new HorizontalLayout();
    private final Label lb11 = new Label("居住情况：");
    private final WCheckBox livingConditions = new WCheckBox();

    private final HorizontalLayout hor12 = new HorizontalLayout();
    private final Label lb12 = new Label("政府扶助类型：");
    private final WRadioButton wrafuzhu = new WRadioButton();
    private final WRadioButton wchfuzhu = new WRadioButton();

    private final HorizontalLayout hor13 = new HorizontalLayout();
    private final Label xin13 = new Label("*");
    private final Label lb13 = new Label("食物过敏史：");
    private final WRadioButton wraguom = new WRadioButton();
    private final Label lb131 = new Label("名称：");
    private final TextField tfguom = new TextField();

    private final HorizontalLayout hor14 = new HorizontalLayout();
    private final Label lb14 = new Label("食物禁忌：");
    private final WCheckBox wchjinji = new WCheckBox();
    private final HorizontalLayout horitf = new HorizontalLayout();
    private final TextField jjtf = new TextField();

    @Autowired
    @Qualifier("validator")
    private javax.validation.Validator javaxValidator;

    @Override
    public void initView(AddSubjectPresenter presenter, RegionalismPresenter regPresenter) {
        center();
        this.setResizable(false);
        this.setSizeUndefined();
        this.setModal(true);
        this.setContent(mainvly);
        buildView();
        bind(presenter, regPresenter);

    }

    public void buildView() {
        addStyle();
        this.setContent(mainvly);
        mainvly.addComponents(hor1, hor2, hor3, hor4, hor5, hor10, hor11, hor12, hordis, hor55, hor6,
                hor66, hor13, hor14, hor7, hor8, hor9);
        hor1.addComponents(lbtitle);
        hor2.addComponents(xin1, lbname, name, xin2, lbsubjectType, subjectType);
        hor3.addComponents(xin3, lbno, idNo, xin4, lbphone, phone);
        hor4.addComponents(xin2ll, lbreg);
        hor5.addComponents(xin33, lbaddress, address);
        hor55.addComponents(lbeee, overDraft, yuan);
        hor6.addComponents(xin6, lbsdtype, sendType, xin7, lbzcd, mealSite);
        hor66.addComponents(lb666, subjectFoodLove, lb676, isMealHelp);
        hor7.addComponents(lbdesc, desc);
        hor8.addComponents(lbjinji, jinjiName, jjphone, jinjiPhone, jjlb, wnjinji);
        hor9.addComponents(btn1, btn2);
        horlll.addComponents(fhlb, lunchBoxNo);
        hor10.addComponents(lb10, wrahuji, horlll);
        hor11.addComponents(lb11, livingConditions);
        hor12.addComponents(lb12, wrafuzhu, wchfuzhu);
        hor13.addComponents(xin13, lb13, wraguom, lb131, tfguom);
        hor14.addComponents(lb14, wchjinji, horitf);
        horitf.addComponent(jjtf);
        hordis.addComponents(lbdisease, diseases, horibtf);
        horibtf.addComponent(jbtf);
        overDraft.setValue("0.00");
        sendType.addWSelectItem("SITE", "助餐点");
        sendType.addWSelectItem("HOME", "到户上门");
        sendType.bindData();

        wrahuji.addOptionItem("1", "本镇");
        wrahuji.addOptionItem("2", "非本镇");
        wrahuji.bindData();

        wrafuzhu.addOptionItem("2", "否");
        wrafuzhu.addOptionItem("1", "是");
        wrafuzhu.bindData();
        wrafuzhu.setConverter(new com.wit.fxp.nxft.ui.convert.ObjectToBooleanConverter());

        wraguom.addOptionItem("2", "否");
        wraguom.addOptionItem("1", "是");
        wraguom.bindData();
        wraguom.setConverter(new com.wit.fxp.nxft.ui.convert.ObjectToBooleanConverter());

        isMealHelp.addOptionItem("1", "是");
        isMealHelp.addOptionItem("2", "否");
        isMealHelp.bindData();

        jjtf.setVisible(false);
        jbtf.setVisible(false);

        isMealHelp.setConverter(new ObjectToBooleanConverter());
    }

    public void addStyle() {
        this.setWidth("1132px");
        this.setHeight("650px");
        this.mainvly.setSizeUndefined();
        this.mainvly.addStyleName("AddSubjectViewImpl");
        this.xin1.addStyleName("xin1");
        this.xin2.addStyleName("xin2");
        this.xin3.addStyleName("xin3");
        this.xin4.addStyleName("xin4");
        this.xin5.addStyleName("xin5");
        this.xin6.addStyleName("xin6");
        this.xin7.addStyleName("xin7");
        this.xin2ll.addStyleName("xin2llstyle");
        this.hor1.addStyleName("hor1");
        this.lbtitle.addStyleName("lbtitle");

        this.hor2.addStyleName("hor2");
        this.lbname.addStyleName("lbname");
        this.name.addStyleName("name");
        this.lbsubjectType.addStyleName("lbsubjectType");
        this.subjectType.addStyleName("subjectType");

        this.hor3.addStyleName("hor3");
        this.lbno.addStyleName("lbno");
        this.idNo.addStyleName("idNo");
        this.lbphone.addStyleName("lbphone");
        this.phone.addStyleName("phone");

        this.hor4.addStyleName("hor4");
        this.lbreg.addStyleName("lbreg");

        this.hor5.addStyleName("hor5");

        this.hordis.addStyleName("hordis");
        this.lbdisease.addStyleName("lbdisease");
        this.diseases.addStyleName("diseases");
        this.hor55.addStyleName("hor55");
        this.lbeee.addStyleName("lbeee");
        this.overDraft.addStyleName("overDraft");
        this.lbaddress.addStyleName("lbaddress");
        this.address.addStyleName("address");
        this.yuan.addStyleName("hor5yuan");
        this.xin33.addStyleName("xin33");

        this.hor6.addStyleName("hor6");
        this.lbsdtype.addStyleName("lbsdtype");
        this.sendType.addStyleName("sendType");
        this.lbzcd.addStyleName("lbzcd");
        this.mealSite.addStyleName("mealSite");
        this.hor66.addStyleName("hor66");
        this.lb666.addStyleName("lb666");
        this.subjectFoodLove.addStyleName("subjectFoodLove");
        this.lb676.addStyleName("lb676");
        this.isMealHelp.addStyleName("isMealHelp");

        this.hor7.addStyleName("hor7");
        this.lbdesc.addStyleName("lbdesc");
        this.desc.addStyleName("desc");

        this.hor8.addStyleName("hor8");
        this.lbjinji.addStyleName("lbjinji");
        this.jinjiName.addStyleName("jinjiName");
        this.jjphone.addStyleName("jjphone");
        this.jinjiPhone.addStyleName("jinjiPhone");

        this.hor9.addStyleName("hor9");
        this.btn1.addStyleName("btn1");
        this.btn2.addStyleName("btn2");

        this.hor10.addStyleName("hordis");
        this.lb10.addStyleName("lbdisease");
        this.wrahuji.addStyleName("diseases");

        this.hor11.addStyleName("hordis");
        this.lb11.addStyleName("lbdisease");
        this.livingConditions.addStyleName("diseases");

        this.hor12.addStyleName("hordis");
        this.lb12.addStyleName("lbdisease");
        this.wrafuzhu.addStyleName("diseases");
        this.wchfuzhu.addStyleName("wraStyle");

        this.hor13.addStyleName("hordis");
        this.lb13.addStyleName("lbl13style");
        this.xin13.addStyleName("xin13");
        this.wraguom.addStyleName("wra13diseases");

        this.hor14.addStyleName("hordis");
        this.lb14.addStyleName("lbdisease");
        this.wchjinji.addStyleName("diseases");

        this.jjlb.setStyleName("aabsbkdjjbsytle");

        fhlb.setStyleName("addorderfhlbstyle");
        lunchBoxNo.addStyleName("addorderfhtfstyle");
        horlll.setStyleName("addsubjecthorlllstyle");
        horibtf.setStyleName("addorderjbtfstyle");
        horitf.setStyleName("addsubjectjjtfstyle");
        jbtf.addStyleName("addjbtfforadd");
        wnjinji.addStyleName("wnjinjiselect");
    }

    public void bind(AddSubjectPresenter presenter, RegionalismPresenter regPresenter) {

        wrafuzhu.addValueChangeListener(e -> {
            if (wrafuzhu.getValue().getId().equals("1")) {
                wchfuzhu.setVisible(true);
            }
            else {
                wchfuzhu.setVisible(false);
                wchfuzhu.select(null);
            }
        });

        wraguom.addValueChangeListener(e -> {
            if (wraguom.getValue().getId().equals("1")) {
                lb131.setVisible(true);
                tfguom.setVisible(true);
            }
            else {
                tfguom.setValue("");
                lb131.setVisible(false);
                tfguom.setVisible(false);
            }
        });

        diseases.addValueChangeListener(e -> {
            if (diseases.getValue().contains(new IdAndName("99", "其它"))) {
                jbtf.setVisible(true);
            }
            else {
                jbtf.setVisible(false);
                jbtf.setValue("");
            }
        });

        wchjinji.addValueChangeListener(e -> {
            if (wchjinji.getValue().contains(new IdAndName("99", "其他"))) {
                jjtf.setVisible(true);
            }
            else {
                jjtf.setVisible(false);
                jjtf.setValue("");
            }
        });

        AddSubjectCommand command = new AddSubjectCommand();

        FxpBeanFieldGroup<AddSubjectCommand> group = new FxpBeanFieldGroup<>(javaxValidator, AddSubjectCommand.class);
        group.setItemDataSource(command);
        group.bindMemberFields(this);

        btn1.addClickListener(e -> {
            this.close();
        });

        btn2.addClickListener(e -> {
            try {
                group.commit();

                IdAndName other = new IdAndName("99", "其他");
                if (command.getWchjinji().contains(other)) {
                    command.getWchjinji().remove(other);
                    other.setName(jjtf.getValue());
                    command.getWchjinji().add(other);
                }
                IdAndName other1 = new IdAndName("99", "其它");
                if (command.getDiseases().contains(other1)) {
                    command.getDiseases().remove(other1);
                    other1.setName(jbtf.getValue());
                    command.getDiseases().add(other1);
                }

                if (presenter.findByIdNo(command.getIdNo()) != null) {
                    Notification.show("该身份证号码已被注册！");
                    this.idNo.focus();
                    return;
                }

                if (presenter.findByPhone(command.getPhone()) != null) {
                    Notification.show("该电话号码已被注册！");
                    this.phone.focus();
                    return;
                }

                if (regPresenter.getView().getRegionId() == null) {
                    Notification.show("请选择完整的行政区划！");
                    return;
                }

                if (!StringUtils.isEmpty(jinjiName.getValue())) {
                    if (wnjinji.getValue() == IdAndName.EMPTY) {
                        Notification.show("请选择关系！");
                        wnjinji.focus();
                        return;
                    }
                }

                if (command.isWrafuzhu()) {
                    if (wchfuzhu.getValue() == IdAndName.EMPTY || wchfuzhu.getValue() == null) {
                        Notification.show("请选择扶助类型！");
                        return;
                    }
                }

                if (command.isWraguom()) {
                    if (tfguom.getValue() == null || tfguom.getValue().equals("")) {
                        Notification.show("请填写过敏食物名称！");
                        tfguom.focus();
                        return;
                    }
                }

                if (command.getWchjinji().contains(new IdAndName("99", "其他"))) {
                    if (FieldUtils.fieldStringValue(jjtf) == null) {
                        Notification.show("选择了其它，请输入信息！");
                        jjtf.focus();
                        return;
                    }
                }

                if (command.getDiseases().contains(new IdAndName("99", "其它"))) {
                    if (FieldUtils.fieldStringValue(jbtf) == null) {
                        Notification.show("选择了其它，请输入信息！");
                        jbtf.focus();
                        return;
                    }
                }
                presenter.addSubject(command);
                this.close();
            }
            catch (CommitException e1) {
                Notification.show("您输入的数据有误，请检查！");
                e1.getInvalidFields().keySet().forEach(field -> field.markAsDirty());
            }
        });
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshDict(List<IdAndName> teams, List<IdAndName> types, List<IdAndName> diseases,
            List<IdAndName> livecon, List<IdAndName> govhelp, List<IdAndName> jinji, List<IdAndName> relations,
            List<IdAndName> foodLoves) {
        teams.forEach(e -> {
            mealSite.addWSelectItem(e.getId(), e.getName());
        });
        mealSite.bindData();

        types.forEach(e -> {
            subjectType.addWSelectItem(e.getId(), e.getName());
        });
        subjectType.bindData();

        diseases.forEach(e -> {
            this.diseases.addOptionItem(e.getId(), e.getName());
        });
        this.diseases.bindData();

        livecon.forEach(e -> {
            livingConditions.addOptionItem(e.getId(), e.getName());
        });
        livingConditions.bindData();

        govhelp.forEach(e -> {
            wchfuzhu.addOptionItem(e.getId(), e.getName());
        });
        wchfuzhu.bindData();

        jinji.forEach(e -> {
            wchjinji.addOptionItem(e.getId(), e.getName());
        });
        wchjinji.bindData();

        relations.forEach(e -> {
            wnjinji.addWSelectItem(e.getId(), e.getName());
        });
        wnjinji.bindData();

        foodLoves.forEach(e -> {
            subjectFoodLove.addWSelectItem(e.getId(), e.getName());
        });
        subjectFoodLove.bindData();
    }

    @Override
    public void showRegion(Component regionView) {
        hor4.addComponent(regionView);
    }

}
