using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameworkExercises
{
    class EntityFrameworkExercises
    {
        static void Main(string[] args)
        {
            //BlogDbContext blogDbContext = new BlogDbContext();

            //List<Post> posts = blogDbContext.Posts.Select(p => p).ToList();
            //List<User> users = blogDbContext.Users.Select(u => u).ToList();

            // **************************************************** 1. READ DATA ***********************************************************
            //// List posts
            //Pr01ListPosts();

            //// list users
            //Pr02ListUsers(); 

            //// list title and body from Posts
            //Pr03ListTitleAndBodyFromPosts(); 

            //// order data
            //Pr04OrderData();

            //// order by two columns
            //Pr05OrderByTwoColuns();

            //// select authors
            //Pr06SelectAuthors();

            //// joins authors with titles
            //Pr07JoinsAuthorsWithTitles();

            //// select author of specific post
            //Pr08SelectAuthorOfSpecificPost();

            //// order authors of posts descending by id 
            //Pr09OrderPostsAuthors();

            // **************************************************** 2. Create Data ***********************************************************
            //// create post
            //Pr01CreatePost();

            //// create user
            //Pr02CreateUser();

            //// create comment
            //Pr03CreateComment();

            // **************************************************** 3. Update Data ***********************************************************
            ////rename user
            //Pr01RenameUser();

            // **************************************************** 4. Delete Data ***********************************************************

            //// delete comment
            //Pr01DeleteComment();

            // delete post
            Pr02DeletePost();
        }

        private static void Pr02DeletePost()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            Post postInfo = blogDbContext.Posts.Single(p => p.Id == 34);
            blogDbContext.Posts.Remove(postInfo);
            blogDbContext.SaveChanges();

            Console.WriteLine(@"Post #{0} deleted", postInfo.Id);
        }

        private static void Pr01DeleteComment()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            Comment commentInfo = blogDbContext.Comments.Single(c => c.Id == 38);
            blogDbContext.Comments.Remove(commentInfo);
            blogDbContext.SaveChanges();

            Console.WriteLine(@"Comment #{0} deleted", commentInfo.Id);
        }

        private static void Pr03CreateComment()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            Comment comment = new Comment()
            {
                PostId = 34,
                Text = "Toq maminiq e golqm peeeras",
                Date = DateTime.Now
            };

            blogDbContext.Comments.Add(comment);
            blogDbContext.SaveChanges();

            Console.WriteLine("Comment added - '{0}'!", comment.Text);
        }

        private static void Pr01RenameUser()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            User userInfo = blogDbContext.Users.Single(u => u.UserName == "Toncho");
            string oldName = userInfo.FullName;
            userInfo.FullName = "Pylen peeras";
            blogDbContext.SaveChanges();

            Console.WriteLine(@"User '{0}' has been renamed to '{1}'", oldName, userInfo.FullName);
        }

        private static void Pr02CreateUser()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            User user = new User()
            {
                UserName = "Toncho",
                PasswordHash = Guid.NewGuid().ToByteArray(),
                FullName = "Anton Mamin"
            };

            blogDbContext.Users.Add(user);
            blogDbContext.SaveChanges();

            Console.WriteLine("User #{0} Created!", user.Id);
        }

        private static void Pr01CreatePost()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            Post post = new Post()
            {
                AuthorId = 18,
                Title = "Comentar na Maminiq",
                Body = "Bychva e mama",
                Date = DateTime.Now
            };

            blogDbContext.Posts.Add(post);
            blogDbContext.SaveChanges();

            Console.WriteLine("Post #{0} Created!", post.Id);
        }

        private static void Pr09OrderPostsAuthors()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            List<User> users = blogDbContext.Users.Select(u => u).Where(u => u.Posts.Count > 0).OrderByDescending(a => a.Id).ToList();

            foreach (var user in users)
            {
                Console.WriteLine("UserName: {0}", user.UserName);
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine("Posts Count: {0}", user.Posts.Count);
            }
        }

        private static void Pr08SelectAuthorOfSpecificPost()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            var author = blogDbContext.Users.SelectMany(u => u.Posts, (user, post) => new { user.UserName, user.FullName, post.Id }).Single(post => post.Id == 4);

            Console.WriteLine("Username: {0}", author.UserName);
            Console.WriteLine("Fullname: {0}", author.FullName);
            Console.WriteLine();
        }

        private static void Pr07JoinsAuthorsWithTitles()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            var users = blogDbContext.Users.SelectMany(u => u.Posts, (user, post) => new { user.UserName, post.Title });

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Post Title: {0}", user.Title);
                Console.WriteLine();
            }
        }

        private static void Pr06SelectAuthors()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            List<User> users = blogDbContext.Users.Select(u => u).Where(u => u.Posts.Count > 0).ToList();

            foreach (var user in users)
            {
                Console.WriteLine("UserName: {0}", user.UserName);
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine("Posts Count: {0}", user.Posts.Count);
                Console.WriteLine();
            }
        }

        private static void Pr05OrderByTwoColuns()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            var users = blogDbContext.Users.Select(u => new
            {
                u.UserName,
                u.FullName
            })
            .OrderByDescending(u => u.UserName)
            .ThenByDescending(u => u.FullName)
            .ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine();
            }
        }

        private static void Pr04OrderData()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            var users = blogDbContext.Users.Select(u => new
            {
                u.UserName,
                u.FullName
            })
            .OrderBy(u => u.UserName).ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine();
            }
        }

        private static void Pr03ListTitleAndBodyFromPosts()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            var posts = blogDbContext.Posts.Select(p => new
            {
                p.Title,
                p.Body
            }
            ).ToList();

            foreach (var post in posts)
            {
                Console.WriteLine("Title: {0}", post.Title);
                Console.WriteLine("Content: {0}", post.Body);
                Console.WriteLine();
            }
        }

        private static void Pr02ListUsers()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            List<User> users = blogDbContext.Users.Select(u => u).ToList();
            foreach (var user in users)
            {
                Console.WriteLine("ID: {0}", user.Id);
                Console.WriteLine("Name: {0}", user.UserName);
                Console.WriteLine("Comments Count: {0}", user.Comments.Count);
                Console.WriteLine("Posts Count: {0}", user.Posts.Count);
                Console.WriteLine();
            }
        }

        private static void Pr01ListPosts()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            List<Post> posts = blogDbContext.Posts.Select(p => p).ToList();
            foreach (var post in posts)
            {
                Console.WriteLine("Title: {0}", post.Title);
                Console.WriteLine("AuthorId: {0}", post.AuthorId);
                Console.WriteLine("Comments Count: {0}", post.Comments.Count);
                Console.WriteLine("Tags Count: {0}", post.Tags.Count);
                Console.WriteLine();
            }
        }
    }
}
