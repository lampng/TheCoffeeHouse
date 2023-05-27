package PDP201.G6.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.io.ByteArrayOutputStream;

import PDP201.G6.DBHelper;
import PDP201.G6.dao.cat_dao;
import PDP201.G6.R;
import PDP201.G6.dao.drinks_dao;
import PDP201.G6.dao.account_dao;

public class login_activity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText ed_username, ed_password;
    Button btn_login;
    String PREFS = "Save_login";
    SharedPreferences Save_login;
    CheckBox checkBox;
    LottieAnimationView lottie;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String user = ed_username.getText().toString().trim();
            String pass = ed_password.getText().toString().trim();
            if (!user.isEmpty() && !pass.isEmpty()) {
                btn_login.setEnabled(true);
                btn_login.setBackground(getResources().getDrawable(R.drawable.button_submit));
                Log.i("TAG", "onTextChanged: pink orange");
            } else {
                btn_login.setEnabled(false);
                btn_login.setBackground(getResources().getDrawable(R.drawable.button_disable));
                Log.i("TAG", "onTextChanged: gray");
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findID();

        //
        try {
            cat_dao cat_dao = new cat_dao(this);
            //Cà phê================================================================================================================================
            byte[] coffee = getByte(R.drawable.a_bacsiu_nong);
            cat_dao.tempt(1, "Cà phê", coffee);

            drinks_dao drinks_dao = new drinks_dao(this);
            byte[] coffee1 = getByte(R.drawable.a_the_coffee_house_sua_da);
            drinks_dao.tempt(1, 1, "The Coffee House Sữa Đá", coffee1, "Thức uống giúp tỉnh táo tức thì để bắt đầu ngày mới thật hứng khởi. Không đắng khét như cà phê truyền thống, The Coffee House Sữa Đá mang hương vị hài hoà đầy lôi cuốn.", 39.000);

            byte[] coffee2 = getByte(R.drawable.a_ca_phe_sua_nong);
            drinks_dao.tempt(2, 1, "Cà Phê Sữa Nóng", coffee2, "Cà phê được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.", 39.000);

            byte[] coffee3 = getByte(R.drawable.a_bac_siu);
            drinks_dao.tempt(3, 1, "Bạc Sỉu", coffee3, "Bạc sỉu chính là \"Ly sữa trắng kèm một chút cà phê\". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.", 29.000);

            byte[] coffee4 = getByte(R.drawable.a_bacsiu_nong);
            drinks_dao.tempt(4, 1, "Bạc Sỉu Nóng", coffee4, "Bạc sỉu chính là \"Ly sữa trắng kèm một chút cà phê\". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.", 39.000);

            byte[] coffee5 = getByte(R.drawable.a_ca_phe_den_da);
            drinks_dao.tempt(5, 1, "Cà Phê Đen Đá", coffee5, "Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.", 29.000);

            byte[] coffee6 = getByte(R.drawable.a_ca_phe_den_nong);
            drinks_dao.tempt(6, 1, "Cà Phê Đen Nóng", coffee6, "Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.", 39.000);

            byte[] coffee7 = getByte(R.drawable.a_ca_phe_sua_da_chai_fresh_250ml);
            drinks_dao.tempt(7, 1, "Cà Phê Sữa Đá Chai Fresh 250ML", coffee7, "Vẫn là hương vị cà phê sữa đậm đà quen thuộc của The Coffee House nhưng khoác lên mình một chiếc áo mới tiện lợi hơn, tiết kiệm hơn phù hợp với bình thường mới, giúp bạn tận hưởng một ngày dài trọn vẹn. *Sản phẩm dùng ngon nhất trong ngày. *Sản phẩm mặc định mức đường và không đá.", 75.000);

            byte[] coffee8 = getByte(R.drawable.a_caramel_macchiato_da);
            drinks_dao.tempt(8, 1, "Caramel Macchiato Đá", coffee8, "Khuấy đều trước khi sử dụng Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.", 55.00);

            byte[] coffee9 = getByte(R.drawable.a_caramel_macchiato_nong);
            drinks_dao.tempt(9, 1, "Caramel Macchiato Nóng", coffee9, "Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.", 55.000);

            byte[] coffee10 = getByte(R.drawable.a_latte_da);
            drinks_dao.tempt(10, 1, "Latte Đá", coffee10, "Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.", 55.000);

            byte[] coffee11 = getByte(R.drawable.a_latte_nong);
            drinks_dao.tempt(11, 1, "Latte Nóng", coffee11, "Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.", 55.000);

            byte[] coffee12 = getByte(R.drawable.a_americano_da);
            drinks_dao.tempt(12, 1, "Americano Đá", coffee12, "Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.", 45.000);

            byte[] coffee13 = getByte(R.drawable.a_americano_nong);
            drinks_dao.tempt(13, 1, "Americano Nóng", coffee13, "Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.", 45.000);

            byte[] coffee14 = getByte(R.drawable.a_cappuccino_da);
            drinks_dao.tempt(14, 1, "Cappuccino Đá", coffee14, "Capuchino là thức uống hòa quyện giữa hương thơm của sữa, vị béo của bọt kem cùng vị đậm đà từ cà phê Espresso. Tất cả tạo nên một hương vị đặc biệt, một chút nhẹ nhàng, trầm lắng và tinh tế.", 55.000);

            byte[] coffee15 = getByte(R.drawable.a_cappuccino_nong);
            drinks_dao.tempt(15, 1, "Cappuccino Nóng", coffee15, "Capuchino là thức uống hòa quyện giữa hương thơm của sữa, vị béo của bọt kem cùng vị đậm đà từ cà phê Espresso. Tất cả tạo nên một hương vị đặc biệt, một chút nhẹ nhàng, trầm lắng và tinh tế.", 55.000);

            byte[] coffee16 = getByte(R.drawable.a_espresso_da);
            drinks_dao.tempt(16, 1, "Espresso Đá", coffee16, "Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.", 49.000);

            byte[] coffee17 = getByte(R.drawable.a_espresso_nong);
            drinks_dao.tempt(17, 1, "Espresso Nóng", coffee17, "Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.", 45.000);
            //========================================================================================================================================
            //========================================================================================================================================
            //CloudFee================================================================================================================================
            byte[] CloudFee = getByte(R.drawable.a_cloudfee_caramel);
            cat_dao.tempt(2, "CloudFee", CloudFee);

            byte[] CloudFee1 = getByte(R.drawable.a_cloudfee_caramel);
            drinks_dao.tempt(18, 2, "CloudFee Caramel", CloudFee1, "Ngon khó cưỡng bởi xíu đắng nhẹ từ cà phê phin truyền thống pha trộn với Espresso lừng danh nước Ý, quyện vị kem sữa và caramel ngọt ngọt, thêm lớp foam trứng cacao bồng bềnh béo mịn, kèm topping thạch cà phê dai giòn nhai cực cuốn. Một thức uống \"điểm mười\" cho cả ngày tươi không cần tưới.", 49.000);

            byte[] CloudFee2 = getByte(R.drawable.a_cloudfee_ha_noi);
            drinks_dao.tempt(19, 2, "CloudFee Hà Nội", CloudFee2, "Khiến bạn mê mẩn ngay ngụm đầu tiên bởi vị đắng nhẹ của cà phê phin truyền thống kết hợp Espresso Ý, quyện hòa cùng chút ngọt ngào của kem sữa, và thơm béo từ foam trứng cacao. Nhấp một ngụm rồi nhai cùng thạch cà phê dai dai giòn giòn, đúng chuẩn \"ngon quên lối về\". CloudFee Classic là món đậm vị cà phê nhất trong bộ sưu tập nhưng không quá đắng, ngậy nhưng không hề ngấy.", 49.000);
            //========================================================================================================================================
            //========================================================================================================================================
            //CloudTea================================================================================================================================
            byte[] CloudTea = getByte(R.drawable.a_cloudtea_oolong_nuong_caramel);
            cat_dao.tempt(3, "CloudTea", CloudTea);

            byte[] CloudTea1 = getByte(R.drawable.a_cloudtea_oolong_nuong_caramel);
            drinks_dao.tempt(20, 3, "CloudTea Oolong Nướng Caramel", CloudTea1, "Hội mê cheese sao có thể bỏ lỡ chiếc trà sữa siêu mlem này. Món đậm vị Oolong nướng - nền trà được yêu thích nhất hiện nay, quyện thêm kem sữa thơm béo. Đặc biệt, chinh phục ngay fan ghiền cheese bởi lớp foam phô mai mềm tan mằn mặn. Càng ngon cực với thạch Oolong nướng nguyên chất giòn dai nhai siêu thích.", 55.000);

            byte[] CloudTea2 = getByte(R.drawable.a_cloudtea_oolong_nuong_kem_cheese);
            drinks_dao.tempt(21, 3, "CloudTea Oolong Nướng Kem Cheese", CloudTea2, "Chiếc trà sữa chân ái dành cho tín đồ hảo ngọt gọi tên CloudTea Oolong Nướng Caramel. Sự kết hợp của foam trứng béo mịn, caramel thơm lừng, trà Oolong nướng rõ vị quyện kem sữa ngọt ngào, làm tan chảy vị giác tựa khoảnh khắc chạm môi người thương. Thêm bột cacao đậm đà và thạch Oolong nướng dai giòn giúp độ ngon nhân đôi.", 55.000);

            byte[] CloudTea3 = getByte(R.drawable.a_cloudtea_oolong_nuong_kem_dua_da_xay);
            drinks_dao.tempt(22, 3, "CloudTea Oolong Nướng Kem Dừa Đá Xay", CloudTea3, "Trà sữa đá xay - phiên bản nâng cấp đầy mới lạ của trà sữa truyền thống, lần đầu xuất hiện tại Nhà. Ngon khó cưỡng với lớp kem dừa béo ngậy nhưng không ngấy, thêm vụn bánh quy phô mai giòn tan vui miệng. Trà Oolong nướng rõ hương đậm vị, quyện với sữa dừa beo béo, được xay mịn cùng đá, mát rượi trong tích tắc. Đặc biệt, thạch Oolong nướng nguyên chất giúp giữ trọn vị đậm đà của trà sữa đến giọt cuối cùng.", 55.000);
            //========================================================================================================================================
            //========================================================================================================================================
            //Tea================================================================================================================================
            byte[] Teafruit = getByte(R.drawable.a_tra_hat_sen_da);
            cat_dao.tempt(4, "Trà Trái Cây", Teafruit);

            byte[] Teafruit1 = getByte(R.drawable.a_tra_dao_cam_xa_nong);
            drinks_dao.tempt(23, 4, "Trà Đào Cam Sả - Nóng", Teafruit1, "Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.", 59.000);

            byte[] Teafruit2 = getByte(R.drawable.a_tra_dao_cam_xa_chai_fresh_500ml);
            drinks_dao.tempt(24, 4, "Trà Đào Cam Sả Chai Fresh 500ML", Teafruit2, "Với phiên bản chai fresh 500ml, thức uống \"best seller\" đỉnh cao mang một diện mạo tươi mới, tiện lợi, phù hợp với bình thường mới và vẫn giữ nguyên vị thanh ngọt của đào, vị chua dịu của cam vàng nguyên vỏ và vị trà đen thơm lừng ly Trà đào cam sả nguyên bản. *Sản phẩm dùng ngon nhất trong ngày. *Sản phẩm mặc định mức đường và không đá.\n" +
                    "\n", 105.000);

            byte[] Teafruit3 = getByte(R.drawable.a_tra_hat_sen_da);
            drinks_dao.tempt(25, 4, "Trà Hạt Sen - Đá", Teafruit3, "Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi và lớp foam cheese béo ngậy. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.\n" +
                    "\n", 49.000);

            byte[] Teafruit4 = getByte(R.drawable.a_tra_hat_sen_nong);
            drinks_dao.tempt(26, 4, "Trà Hạt Sen - Nóng", Teafruit4, "Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi thơm ngon. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.\n" +
                    "\n", 59.000);

            byte[] Teafruit5 = getByte(R.drawable.a_tra_long_nhan_hat_sen);
            drinks_dao.tempt(27, 4, "Trà Long Nhãn Hạt Sen", Teafruit5, "Thức uống mang hương vị của nhãn, của sen, của trà Oolong đầy thanh mát cho tất cả các thành viên trong dịp Tết này. An lành, thư thái và đậm đà chính là những gì The Coffee House mong muốn gửi trao đến bạn và gia đình.", 49.000);
            //========================================================================================================================================
            //========================================================================================================================================
            //Tea================================================================================================================================
            byte[] MilkTea = getByte(R.drawable.a_tra_den_macchiato);
            cat_dao.tempt(5, "Trà Sữa Macchiato", MilkTea);

            byte[] MilkTea1 = getByte(R.drawable.a_hong_tra_sua_nong);
            drinks_dao.tempt(28, 5, "Hồng Trà Sữa Nóng", MilkTea1, "Từng ngụm trà chuẩn gu ấm áp, đậm đà beo béo bởi lớp sữa tươi chân ái hoà quyện. Trà đen nguyên lá âm ấm dịu nhẹ, quyện cùng lớp sữa thơm béo khó lẫn - hương vị ấm áp chuẩn gu trà, cho từng ngụm nhẹ nhàng, ngọt dịu lưu luyến mãi nơi cuống họng.\n" +
                    "\n", 55.000);

            byte[] MilkTea2 = getByte(R.drawable.a_hong_tra_sua_tran_chau);
            drinks_dao.tempt(29, 5, "Hồng Trà Sữa Trân Châu", MilkTea2, "Thêm chút ngọt ngào cho ngày mới với hồng trà nguyên lá, sữa thơm ngậy được cân chỉnh với tỉ lệ hoàn hảo, cùng trân châu trắng dai giòn có sẵn để bạn tận hưởng từng ngụm trà sữa ngọt ngào thơm ngậy thiệt đã.", 55.000);

            byte[] MilkTea3 = getByte(R.drawable.a_tra_den_macchiato);
            drinks_dao.tempt(30, 5, "Trà Đen Macchiato", MilkTea3, "Trà đen được ủ mới mỗi ngày, giữ nguyên được vị chát mạnh mẽ đặc trưng của lá trà, phủ bên trên là lớp Macchiato \"homemade\" bồng bềnh quyến rũ vị phô mai mặn mặn mà béo béo.", 55.000);

            byte[] MilkTea4 = getByte(R.drawable.a_tra_sua_mac_ca_tran_chau);
            drinks_dao.tempt(31, 5, "Trà Sữa Mắc Ca Trân Châu", MilkTea4, "Mỗi ngày với The Coffee House sẽ là điều tươi mới hơn với sữa hạt mắc ca thơm ngon, bổ dưỡng quyện cùng nền trà oolong cho vị cân bằng, ngọt dịu đi kèm cùng Trân châu trắng giòn dai mang lại cảm giác “đã” trong từng ngụm trà sữa.\n" +
                    "\n", 55.000);

            byte[] MilkTea5 = getByte(R.drawable.a_tra_sua_olong_nuong_nong);
            drinks_dao.tempt(32, 5, "Trà sữa Oolong Nướng (Nóng)", MilkTea5, "Đậm đà chuẩn gu và ấm nóng - bởi lớp trà oolong nướng đậm vị hoà cùng lớp sữa thơm béo. Hương vị chân ái đúng gu đậm đà - trà oolong được \"sao\" (nướng) lâu hơn cho vị đậm đà, hoà quyện với sữa thơm ngậy. Cho từng ngụm ấm áp, lưu luyến vị trà sữa đậm đà mãi nơi cuống họng.\n" +
                    "\n", 55.000);

            byte[] MilkTea6 = getByte(R.drawable.a_tra_sua_olong_nuong_chai_fresh_500ml);
            drinks_dao.tempt(33, 5, "Trà Sữa Oolong Nướng Trân Châu Chai Fresh 500ML", MilkTea6, "Phiên bản chai fresh 500ml mới, The Coffee House tin rằng với diện mạo mới: tiện lợi và phù hợp với bình thường mới này, các tín đồ trà sữa sẽ được thưởng thức hương vị đậm đà, hòa quyện với sữa thơm béo mang đến cảm giác mát lạnh ở bất cứ nơi đâu. *Sản phẩm dùng ngon nhất trong ngày. *Sản phẩm mặc định mức đường và không đá.\n" +
                    "\n", 95.000);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        lottie = findViewById(R.id.lottie);
        lottie.setRepeatCount(LottieDrawable.INFINITE);

        account_dao account_dao = new account_dao(this);
        ed_username.addTextChangedListener(textWatcher);
        ed_password.addTextChangedListener(textWatcher);

        Save_login = getSharedPreferences(PREFS, 0);
        boolean rememberMe = Save_login.getBoolean("rememberMe", false);
        if (rememberMe == true) {
            //get previously stored login details
            String login = Save_login.getString("login", null);
            String upass = Save_login.getString("password", null);

            if (login != null && upass != null) {
                //fill input boxes with stored login and pass
                EditText loginEbx = findViewById(R.id.ed_username);
                EditText passEbx = findViewById(R.id.ed_password);
                loginEbx.setText(login);
                passEbx.setText(upass);

                //set the check box to 'checked'
                CheckBox rememberMeCbx = (CheckBox) findViewById(R.id.checkBox);
                rememberMeCbx.setChecked(true);
            }
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kiểm tra đăng nhập
                String u = ed_username.getText().toString();
                String p = ed_password.getText().toString();
                //khi điều kiện đúng
                if (account_dao.login(u, p)) {
                    //Lưu mật khẩu
                    CheckBox rememberMeCbx = (CheckBox) findViewById(R.id.checkBox);
                    boolean isChecked = rememberMeCbx.isChecked();
                    if (isChecked) {
                        //Nếu checkbox = true
                        saveLoginDetails();
                        Log.i("", "save login ");
                    } else {
                        //Nếu checkbox = false
                        removeLoginDetails();
                        Log.i("", "remove save login ");
                    }
                    startActivity(new Intent(login_activity.this, MainActivity.class).setFlags((Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)));
                    Animatoo.INSTANCE.animateSlideLeft(login_activity.this);
                    //khi điều kiện sai, thông báo Toast
                } else {
                    FancyToast.makeText(login_activity.this, "Infomation don't match!", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                }
            }
        });
        //Forgot
        findViewById(R.id.tv_forgot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_activity.this, forgot_activity.class));
                Animatoo.INSTANCE.animateSlideLeft(login_activity.this);
            }
        });
        //Register
        findViewById(R.id.tv_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_activity.this, register_activity.class));
                Animatoo.INSTANCE.animateSlideLeft(login_activity.this);
            }
        });
    }

    private void findID() {
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);
        checkBox = findViewById(R.id.checkBox);
    }

    //Remember
    private void saveLoginDetails() {
        EditText loginEbx = findViewById(R.id.ed_username);
        EditText passEbx = findViewById(R.id.ed_password);
        String login = loginEbx.getText().toString();
        String upass = passEbx.getText().toString();
        SharedPreferences.Editor e = Save_login.edit();
        e.putBoolean("rememberMe", true);
        e.putString("login", login);
        e.putString("password", upass);
        e.commit();
    }

    private void removeLoginDetails() {
        SharedPreferences.Editor e = Save_login.edit();
        e.putBoolean("rememberMe", false);
        e.remove("login");
        e.remove("password");
        e.commit();
    }

    private byte[] getByte(int drawable) {
        Resources res = getResources();
        Drawable dra = res.getDrawable(drawable);
        Bitmap bitmap = ((BitmapDrawable) dra).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bitMapData = stream.toByteArray();
        return bitMapData;
    }
}