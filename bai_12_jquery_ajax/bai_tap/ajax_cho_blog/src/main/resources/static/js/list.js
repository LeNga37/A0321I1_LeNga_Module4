// function getListBlog() {
//     var titleBlog = $("#titleBlog").val();
//     $.ajax({
//         url: "/blog/searchTitleBlog",
//         data:{
//             titleBlog: titleBlog
//         },
//         type: 'json',
//         dataType: "HTML",
//         success: function (response) {
//             var result='';
//             for(let i = 0;i<response.length;i++){
//                 result +=`
//                 <td th:text="${blog.id}"></td>
//                 <td th:text="${blog.title}"></td>
//                 <td th:text="${blog.category.categoryName}"></td>
//                 <td th:text="${blog.date}"></td>
//                 <td><a th:href="@{/blog/detail/__${blog.id}__ }">Detail</a></td>
//                 <td><a th:href="@{/blog/edit/__${blog.id}__ }">Edit</a></td>
//                 <td><a th:href="@{/blog/delete/__${blog.id}__ }">Delete</a></td>
//                 `;
//             }
//         }
//     });
// }

$(document).ready(function () {
    $("#searchTitle").click(function () {
        var word = $("#key_search").val();
        console.log(key_search);
        $.ajax({
            type: "GET",
            url: "/blog/list?key_search=" + key_search,
            dataType: "HTML",
            success: function (data) {
                $(".blog-jquery").html(data);
            }
        })
    })
})

$(document).ready(function () {
    $("#more").click(function () {
        $.ajax({
            type: "GET",
            url: "/blog/list-more",
            dataType: "HTML",
            success: function (data) {
                $(".blog-jquery").html(data);
            }
        })
    })
})