package afkt.project.ui.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

import afkt.project.R;
import afkt.project.model.bean.CommodityEvaluateBean;
import afkt.project.util.ProjectUtils;
import dev.other.GlideUtils;
import dev.utils.app.ViewUtils;
import dev.utils.common.BigDecimalUtils;

/**
 * detail: Item Slide Adapter
 * @author Ttt
 */
public class ItemSlideAdapter extends BaseQuickAdapter<CommodityEvaluateBean, BaseViewHolder> {

    public ItemSlideAdapter(@Nullable List<CommodityEvaluateBean> data) {
        super(R.layout.adapter_multi_select, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityEvaluateBean item) {
        // 当前索引
        int position = helper.getLayoutPosition();
        // 判断是否显示边距
        ViewUtils.setVisibility(position == 0, helper.getView(R.id.vid_ams_line));

        // ============
        // = 商品信息 =
        // ============

        // 商品名
        helper.setText(R.id.vid_ams_name_tv, item.commodityName);
        // 商品价格
        helper.setText(R.id.vid_ams_price_tv,
                "￥" + BigDecimalUtils.round(item.commodityPrice, 2));
        // 商品图片
        GlideUtils.with().displayImage(item.commodityPicture, helper.getView(R.id.vid_ams_pic_igview), ProjectUtils.getRoundOptions());
    }
}
