package com.wit.fxp.nxft.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.compound.model.DeliveDetailModel;
import com.wit.fxp.nxft.compound.model.DeliveNoteModel;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.compound.model.NxftOrderCollectModel;
import com.wit.fxp.nxft.compound.model.NxftOrderDetailModel;
import com.wit.fxp.nxft.domain.model.dict.MealType;
import com.wit.fxp.nxft.domain.model.order.DeliveDetail;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

@Mapper
public interface CompoundOrderMapper {

    CompoundOrderMapper INSTANCE = Mappers.getMapper(CompoundOrderMapper.class);

    NxftOrderDetailModel.LastState mapOrder(NxftOrder.LastState entity);

    NxftOrderDetailModel.CreateInfo mapOrder(NxftOrder.CreateInfo entity);

    NxftOrderDetailModel.SubjectInfo mapOrder(NxftOrder.SubjectInfo entity);

    NxftOrderDetailModel.SettleInfo mapOrder(NxftOrder.SettleInfo entity);

    NxftOrderDetailModel.MealInfo mapOrder(NxftOrder.MealInfo entity);

    NxftOrderDetailModel mapOrder(NxftOrder entity);

    List<NxftOrderDetailModel> mapOrder(List<NxftOrder> entity);

    DeliveNoteModel.NextNode mapDeliveNote(DeliveNote.NextNode entity);

    DeliveNoteModel.CompleteInfo mapDeliveNote(DeliveNote.CompleteInfo entity);

    DeliveNoteModel.CreateInfo mapDeliveNote(DeliveNote.CreateInfo entity);

    DeliveNoteModel.DeliveInfo mapDeliveNote(DeliveNote.DeliveInfo entity);

    DeliveNoteModel.LastState mapDeliveNote(DeliveNote.LastState entity);

    List<DeliveNoteModel> mapDeliveNote(List<DeliveNote> entity);

    DeliveDetailModel mapDeliveDetail(DeliveDetail entity);

    List<DeliveDetailModel> mapDeliveDetail(List<DeliveDetail> entity);

    @Mapping(source = "mealInfo.mealDate", target = "mealDate")
    @Mapping(source = "mealInfo.mealTypeId", target = "mealTypeId")
    @Mapping(source = "mealInfo.mealTypeName", target = "mealTypeName")
    @Mapping(source = "mealInfo.mealId", target = "mealId")
    @Mapping(source = "mealInfo.mealName", target = "mealName")
    @Mapping(source = "settleInfo.quantity", target = "quantity")
    NxftOrderCollectModel mapNxftOrderCollect(NxftOrder entity);

    List<NxftOrderCollectModel> mapNxftOrderCollect(List<NxftOrder> entity);

    @Mapping(source = "id", target = "mealTypeId")
    MealTypeModel mapMealType(MealType entity);

    List<MealTypeModel> mapMealType(List<MealType> entity);
}
