var loadFile = function (event, idthem) {
    var output = document.getElementById('output' + idthem + '');
    output.style.width = "200px";
    output.className = "img-response";

    output.src = URL.createObjectURL(event.target.files[0]);
};
$(function () {
    function previewImages() {

        var preview = $('#gallery').empty();
        if (this.files)
            $.each(this.files, readAndPreview);

        function readAndPreview(i, file) {

            if (!/\.(jpe?g|png|gif)$/i.test(file.name)) {
                return alert(file.name + " is not an image");
            } // else...

            var reader = new FileReader();

            $(reader).on("load", function () {
                preview.append($("<img/>", {
                    src: this.result, height: 100, class: 'img-thumbnail', title: file.name
                }));
            });
            reader.readAsDataURL(file);
        }
    }
    $('#prod-images').on("change", previewImages);
});

//Hàm kiểm tra thêm sản phẩm

$(window).ready(function () {
    $('#addproduct').validate({
        onchange: true,
        rules: {
            'prod-name': "required",
            'prod-describe': "required",
            'prod-price': {
                required: true,
                number: true,
                digits: true
            }, 'prod-discount': "number",
            'prod-quantity': {
                required: true,
                number: true,
                digits: true
            },
            'prod-unit': "required",
            'loaiSP': "required",
            'prod-model': "required",
            'prod-cpu': "required",
            'prod-ram': "required",
            'prod-resolution': "required",
            'prod-size': {
                required: true,
                number: true
            },
            'prod-weight': {
                required: true,
                number: true
            },
            'prod-os': "required",
            'prod-thumbnail': {
                required: true,
                extension: "jpg|png|gif|jpeg"
            }
        },
        messages: {
            'prod-name': "Vui lòng nhập tên sản phẩm.",
            'prod-describe': "Vui lòng nhập mô tả.",
            'prod-price': {
                required: "Vui lòng nhập giá.",
                number: "Giá chỉ có số.",
                digits: "Giá phải trên 0."
            },
            'prod-discount': "Không phải số.",
            'prod-quantity': {
                required: "Vui lòng nhập số lượng.",
                number: "Giá chỉ có số.",
                digits: "Số lượng phải trên 0."
            },
            'prod-unit': "Vui lòng nhập đơn vị.",
            'loaiSP': "Vui lòng chọn loại sản phẩm.",
            'prod-model': "Vui lòng nhập model.",
            'prod-cpu': "Vui lòng nhập CPU.",
            'prod-ram': "Vui lòng nhập bộ nhớ trong.",
            'prod-resolution': "Vui lòng nhập độ phân giải.",
            'prod-size': {
                required: "Vui lòng nhập kích thước màn hình.",
                number: "Chỉ nhập số."
            },
            'prod-weight': {
                required: "Vui lòng nhập trọng lượng.",
                number: "Chỉ nhập số."
            },
            'prod-os': "Vui lòng nhập hệ điều hành.",
            'prod-thumbnail': {
                required: "Vui lòng chọn hình đại diện.",
                extension: "Ảnh sẽ có đuôi *.jpg, *.jpeg, *.gif hoặc *.png"
            }
        }
    });
});

//Hàm kiểm tra thêm sản phẩm

$(window).ready(function () {
    $('#editproduct').validate({
        onchange: true,
        rules: {
            'prod-name': "required",
            'prod-describe': "required",
            'prod-price': {
                required: true,
                number: true,
                digits: true
            }, 'prod-discount': "number",
            'prod-quantity': {
                required: true,
                number: true,
                digits: true
            },
            'prod-unit': "required",
            'loaiSP': "required",
            'prod-model': "required",
            'prod-cpu': "required",
            'prod-ram': "required",
            'prod-resolution': "required",
            'prod-size': {
                required: true,
                number: true
            },
            'prod-weight': {
                required: true,
                number: true
            },
            'prod-os': "required",
            'prod-thumbnail': {
                extension: "jpg|png|gif|jpeg"
            }
        },
        messages: {
            'prod-name': "Vui lòng nhập tên sản phẩm.",
            'prod-describe': "Vui lòng nhập mô tả.",
            'prod-price': {
                required: "Vui lòng nhập giá.",
                number: "Giá chỉ có số.",
                digits: "Giá phải trên 0."
            },
            'prod-discount': "Không phải số.",
            'prod-quantity': {
                required: "Vui lòng nhập số lượng.",
                number: "Giá chỉ có số.",
                digits: "Số lượng phải trên 0."
            },
            'prod-unit': "Vui lòng nhập đơn vị.",
            'loaiSP': "Vui lòng chọn loại sản phẩm.",
            'prod-model': "Vui lòng nhập model.",
            'prod-cpu': "Vui lòng nhập CPU.",
            'prod-ram': "Vui lòng nhập bộ nhớ trong.",
            'prod-resolution': "Vui lòng nhập độ phân giải.",
            'prod-size': {
                required: "Vui lòng nhập kích thước màn hình.",
                number: "Chỉ nhập số."
            },
            'prod-weight': {
                required: "Vui lòng nhập trọng lượng.",
                number: "Chỉ nhập số."
            },
            'prod-os': "Vui lòng nhập hệ điều hành.",
            'prod-thumbnail': {
                extension: "Ảnh sẽ có đuôi *.jpg, *.jpeg, *.gif hoặc *.png"
            }
        }
    });
});

//Hàm kiểm tra nhập email
$(window).ready(function () {
    $('#form-contact').validate({
        onchange: true,
        rules: {
            'cName': "required",
            'cSubject': "required",
            'cEmail': {
                required: true,
                email: true
            },
            'cMessage': {
                required: true,
                minlength: 20,
                maxlength: 300
            }
        },
        messages: {
            'cName': "Vui lòng nhập họ tên.",
            'cSubject': "Vui lòng nhập tiêu đề.",
            'cEmail': {
                required: "Vui lòng nhập email người gửi.",
                email: "Email không hợp lệ"
            },
            'cMessage': {
                required: "Vui lòng nhập lời nhắn.",
                minlength: "Vui lòng nhập ít nhất 20 kí tự.",
                maxlength: "Nhiều nhất 300 kí tự."
            }
        }
    });
});

$(window).ready(function () {
    $('#edituser').validate({
        onchange: true,
        rules: {
            'username': {
                required: true,
                minlength: 6
            },
            'password': {
                required: true,
                minlength: 6
            },
            'repassword': {
                required: true,
                equalTo: "#password"
            },
            'role': 'required',
            'fullname': 'required',
            'dienthoai': {
                required: true,
                number: true,
                minlength: 10,
                maxlength: 11
            },
            'address': 'required',
            'email': {
                required: true,
                email: true
            }
        },
        messages: {
            'username': {
                required: "Bạn chưa nhập tên đăng nhập",
                minlength: 'Tên đăng nhập chưa đủ 6 ký tự'
            },
            'password': {
                required: "Bạn chưa nhập mật khẩu",
                minlength: 'Mật khẩu chưa đủ 6 ký tự'
            },
            'repassword': {
                required: 'Vui lòng nhập lại mật khẩu',
                equalTo: "Mật khẩu nhập lại sai"
            },
            'role': 'Vui lòng chọn quyền',
            'fullname': 'Bạn chưa nhập họ tên ',
            'dienthoai': {
                required: 'Chưa nhập điện thoại',
                number: 'Điện thoại chỉ có số',
                minlength: 'Số điện thoại không hợp lệ',
                maxlength: 'Số điện thoại không hợp lệ'
            },
            'address': 'Bạn chưa nhập địa chỉ',
            'email': {
                required: 'Chưa nhập email',
                email: 'Email không hợp lệ'
            }
        }
    });
});

function loadXMLProductName() {
    var xmlhttp;
    var productName = document.getElementById("prod-name").value;
    var formEdit = document.forms[0].id;

    if (formEdit == 'editproduct') {
        var oldName = document.getElementById("prod-old-name").value;
    }

    var urls = "CheckProductName.jsp?tsp=" + productName + "&old=" + oldName;

    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            document.getElementById('errProdName').style.color = "red";
            document.getElementById('errProdName').innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", urls, true);
    xmlhttp.send();
}

function validateFormProduct() {
    var x = document.forms["fProduct"]["prod-name"].value;
    if (x != "") {
        var y = document.getElementById('actual').value;
    }
    if (y == "taken") {
        alert("Tên sản phẩm đã tồn tại");
//        document.getElementById('errProdName').style.color = "red";
//        document.getElementById('errProdName').innerHTML = 'Tồn tại';
        return false;
    } else {

    }
}
// kiểm tra trùng tên người dùng
function loadXMLUserName() {
    var xmlhttp;
    var UserName = document.getElementById("username").value;
    var urls = "CheckUserName.jsp?username=" + UserName;

    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            document.getElementById('errUserName').style.color = "red";
            document.getElementById('errUserName').innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", urls, true);
    xmlhttp.send();
}

function validateFormUser() {
    var x = document.forms["fUser"]["username"].value;
    if (x != "") {
        var y = document.getElementById('actual').value;
    }
    if (y == "taken") {
        alert("Tên người dùng đã tồn tại");
//        document.getElementById('errProdName').style.color = "red";
//        document.getElementById('errProdName').innerHTML = 'Tồn tại';
        return false;
    } else {

    }
}

//Hàm kiểm tra thông tin đặt hàng
$(window).ready(function () {
    $('#dathang').validate({
        onchange: true,
        rules: {
            'username': "required",
            'email': {
                required: true,
                email: true
            },
            'phonenumber': {
                required: true,
                number: true,
                minlength: 10,
                maxlength: 11
            },
            'address': {
                required: true,
                maxlength: 150
            },
            'city': "required"
        },
        messages: {
            'username': "Vui lòng nhập họ tên người nhận.",
            'email': {
                required: "Vui lòng nhập email.",
                email: "Email không hợp lệ."
            },
            'phonenumber': {
                required: "Vui lòng nhập số điện thoại.",
                number: "Số điện thoại không có chữ.",
                minlength: "Giới hạn 10 đến 11 kí tự.",
                maxlength: "Giới hạn 10 đến 11 kí tự."
            },
            'address': {
                required: "Vui lòng nhập lời nhắn.",
                maxlength: "Nhiều nhất là 150 kí tự"
            },
            'city': "Vui lòng nhập thành phố."
        }
    });
});

//Hàm kiểm tra thông tin bình luận sản phẩm
$(window).ready(function () {
    $('#pcomment').validate({
        onchange: true,
        rules: {
            'cName': "required",
            'cEmail': {
                required: true,
                email: true
            },
            'cMessage': {
                required: true,
                minlength: 20,
                maxlength: 300
            }
        },
        messages: {
            'cName': "Vui lòng nhập họ tên.",
            'cEmail': {
                required: "Vui lòng nhập email.",
                email: "Email không hợp lệ."
            },
            'cMessage': {
                required: "Vui lòng nhập bình luận.",
                minlength: "Vui lòng nhập ít nhất 20 kí tự.",
                maxlength: "Nhiều nhất 300 kí tự."
            }
        }
    });
});

//Hàm kiểm tra thông tin đánh giá
$(window).ready(function () {
    $('#prating').validate({
        onchange: true,
        rules: {
            'cName': "required",
            'cEmail': {
                required: true,
                email: true
            },
            'cMessage': {
                required: true,
                maxlength:300
            }
        },
        messages: {
            'cName': "Vui lòng nhập họ tên.",
            'cEmail': {
                required: "Vui lòng nhập email.",
                email: "Email không hợp lệ."
            },
            'cMessage': {
                required: "Vui lòng nhập đánh giá.",
                maxlength: "Vui lòng nhập không quá 300 kí tự."
            }
        }
    });
});

//Hàm kiểm tra loại sản phẩm
$(window).ready(function () {
    $('#addcategory').validate({
        onchange: true,
        rules: {
            'c-name': "required"
        },
        messages: {
            'c-name': "Vui lòng nhập tên loại."
        }
    });
});

//Kiểm tra đăng ký 
$(window).ready(function () {
    $('#fregister').validate({
        onchange: true,
        rules: {
            'username': {
                required: true,
                minlength: 6
            },
            'mk': {
                required: true,
                minlength: 8
            },
            'repassword': {
                required: true,
                equalTo: "#password"
            },
            'fullname': 'required',
            'dienthoai': {
                required: true,
                number: true,
                rangelength: [10, 11]
            },
            'email': {
                required: true,
                email: true
            },
            'birthday': "required",
            'dieukhoan': "required"
        },
        messages: {
            'username': {
                required: "Bạn chưa nhập tên đăng nhập",
                minlength: 'Tên đăng nhập chưa đủ 6 ký tự'
            },
            'mk': {
                required: "Bạn chưa nhập mật khẩu",
                minlength: 'Mật khẩu chưa đủ 8 ký tự'
            },
            'repassword': {
                required: 'Vui lòng nhập lại mật khẩu',
                equalTo: "Mật khẩu nhập lại sai"
            },
            'role': 'Vui lòng chọn quyền',
            'fullname': 'Bạn chưa nhập họ tên ',
            'dienthoai': {
                required: 'Chưa nhập điện thoại',
                number: 'Điện thoại chỉ có số',
                rangelength: 'Điện thoại có độ dài 10-11 số'
            },
            'email': {
                required: 'Chưa nhập email',
                email: 'Email không hợp lệ'
            },
            'birthday': "Vui lòng chọn ngày sinh.",
            'dieukhoan': "Vui lòng đồng ý điều khoản"
        }
    });
});

//Kiem tra nhap thong tin nguoi dung

$(window).ready(function () {
    $('#editinfo').validate({
        onchange: true,
        rules: {
            'username': {
                required: true,
                minlength: 6
            },
            'password': {
                required: true,
                minlength: 6
            },
            'repassword': {
                required: true,
                equalTo: "#password"
            },
            'role': 'required',
            'fullname': 'required',
            'dienthoai': {
                required: true,
                number: true,
                minlength: 10,
                maxlength: 11
            }
        },
        messages: {
            'username': {
                required: "Bạn chưa nhập Họ và Tên",
                minlength: 'Họ và Tên chưa đủ 6 ký tự,không để trống ô này'
            },
            'password': {
                required: "Bạn chưa nhập mật khẩu",
                minlength: 'Mật khẩu chưa đủ 6 ký tự'
            },
            'repassword': {
                required: 'Vui lòng nhập lại mật khẩu',
                equalTo: "Mật khẩu nhập lại sai"
            },
            'dienthoai': {
                required: 'Chưa nhập điện thoại',
                number: 'Điện thoại chỉ có số',
                minlength: 'Số điện thoại không hợp lệ',
                maxlength: 'Số điện thoại không hợp lệ'
            },
            'address': 'Bạn chưa nhập địa chỉ',
            'email': {
                required: 'Chưa nhập email',
                email: 'Email không hợp lệ'
            }
        }
    });
});

function loadXMLNewPassword() {
    var xmlhttp;
    var iduser = document.getElementById("iduser").value;
    var mknhap = document.getElementById("mkcunhap").value;

    var urls = "NewPassword.jsp?id=" + iduser + "&nhap=" + mknhap;

    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            document.getElementById('errPassword').style.color = "red";
            document.getElementById('errPassword').innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", urls, true);
    xmlhttp.send();
}

function validatePassword() {
    var x = document.forms["fPWD"]["mkcunhap"].value;
    if (x != "") {
        var y = document.getElementById('actual').value;
    }
    if (y == "taken") {
        alert("Saipass");
//        document.getElementById('errProdName').style.color = "red";
//        document.getElementById('errProdName').innerHTML = 'Tồn tại';
        return false;
    } else {

    }
}

//Kiem tra nhap thong tin sửa hóa đơn

$(window).ready(function () {
    $('#editreceipt').validate({
        onchange: true,
        rules: {
            'rtbuyer': "required",
            'rtemail': {
                required: true,
                email: true
            },
            'rtaddress':"required",
            'rtphone': {
                required:true,
                number: true,
                rangelength: [10, 11]
            }
        },
        messages: {
            'rtbuyer': "Vui lòng nhập tên người mua",
            'rtemail': {
                required: "Vui lòng nhập email",
                email: "Email không hợp lệ"
            },
            'rtaddress':"Vui lòng nhập địa chỉ",
            'rtphone': {
                required:"Vui lòng nhập số điện thoại",
                number: "SĐT phải là số",
                rangelength: "SĐT có độ dài từ 10-11"
            }
        }
    });
});
