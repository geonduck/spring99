const main = {
    init : function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.pwPrompt(_this.save);
        });
        $('#btn-update').on('click', function () {
            _this.pwPrompt(_this.update);
        });
        $('#btn-delete').on('click', function () {
            _this.pwPrompt(_this.delete);
        });
    },
    pwPrompt : function(e) {
        let pw = prompt('비밀번호를 입력하세요.');
        if(pw != null && pw !== '') e(pw);
        else alert('비밀번호를 확인하세요.');
    },

    save : function (pw) {
        let data = {
            title : $('#title').val()
            , content : $('#content').val()
            , author : $('#author').val()
            , pw : pw
        };

        $.ajax({
            type: 'POST'
            , url: '/api/v1/posts'
            , dataType: 'json'
            , contentType: 'application/json; charset=UTF-8'
            , data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    update : function (pw) {
        let data = {
              title : $('#title').val()
            , content: $('#content').val()
            , pw : pw
        }

        let id =  $('#id').val();

        $.ajax({
            type: 'PUT'
            , url: '/api/v1/posts/'+ id
            , dataType: 'json'
            , contentType: 'application/json; charset=UTF-8'
            , data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.')
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        })
    },
    delete : function (pw) {

        let id =  $('#id').val();

        $.ajax({
            type: 'DELETE'
            , url: '/api/v1/posts/'+ id
            , dataType: 'json'
            , contentType: 'application/json; charset=UTF-8'
            , data: JSON.stringify({pw : pw})
        }).done(function () {
            alert('글이 삭제되었습니다.')
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error))
        })
    }
};

main.init();