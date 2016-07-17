using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlogDbApp
{
    class EntityFramework
    {
        static void Main(string[] args)
        {
            //// list users from DB
            //Pr01ListUsers();

            //// list posts query + posts
            //Pr02ListsQueryAndPosts();

            //// create new post in DB
            //Pr03CreateNewPosts();

            //// cascading insert
            //Pr04CascadingInsert();

            //// update date in DB
            //Pr05UpdateData();

            //// delete existing data
            //Pr06DeleteLastPost(); 

            // native SQL
            Pr07ListPostsBetween2Dates();
        }

        private static void Pr07ListPostsBetween2Dates()
        {
            var db = new BlogDbContext();
            var startDate = new DateTime(2016, 05, 19);
            var endDate = new DateTime(2016, 06, 14);

            var posts = db.Database.SqlQuery<PostData>(@"SELECT ID, Title, Date FROM Posts WHERE CONVERT(date, Date) BETWEEN {0} AND {1} ORDER BY Date", startDate, endDate);

            foreach (var p in posts)
            {
                Console.WriteLine($"{p.ID}: {p.Title} ({p.Date})");
            }
        }

        private static void Pr06DeleteLastPost()
        {
            var db = new BlogDbContext();
            var lastPost = db.Posts.OrderByDescending(p => p.Id).First();
            db.Comments.RemoveRange(lastPost.Comments);
            lastPost.Tags.Clear();
            db.Posts.Remove(lastPost);
            db.SaveChanges();
            Console.WriteLine($"Deleted post #{lastPost.Id}");
        }

        private static void Pr05UpdateData()
        {
            var db = new BlogDbContext();
            var user = db.Users.Where(u => u.UserName == "Mariika").First();

            user.PasswordHash = Guid.NewGuid().ToByteArray();
            db.SaveChanges();
            Console.WriteLine("User #{0} {1} has a new random password.", user.Id, user.UserName);
        }

        private static void Pr04CascadingInsert()
        {
            var db = new BlogDbContext();
            var post = new Post()
            {
                Title = "New Post Title",
                Date = DateTime.Now,
                Body = "This post have comments and tags",
                User = db.Users.First(),
                Comments = new Comment[]
                {
                    new Comment() {Text = "Comment 1", Date = DateTime.Now },
                    new Comment() {Text = "Comment 2", Date = DateTime.Now, User = db.Users.First() }
                },
                Tags = db.Tags.Take(3).ToList()
            };
            db.Posts.Add(post);
            db.SaveChanges();
        }

        private static void Pr03CreateNewPosts()
        {
            var db = new BlogDbContext();
            var post = new Post()
            {
                Title = "New Title",
                Body = "new Post Body",
                Date = DateTime.Now
            };
            db.Posts.Add(post);
            db.SaveChanges();
            Console.WriteLine("Post #{0} created.", post.Id);
        }

        private static void Pr02ListsQueryAndPosts()
        {
            var db = new BlogDbContext();

            var posts = db.Posts.Select(p => new { p.Id, p.Title, Comments = p.Comments.Count(), Tags = p.Tags.Count() });

            Console.WriteLine("SQL query:\n{0}\n", posts);
            Console.WriteLine();
            Console.WriteLine();
            foreach (var p in posts)
            {
                Console.WriteLine($"{p.Id} == {p.Title} ({p.Comments} comments, {p.Tags} tags)");
            }
        }

        private static void Pr01ListUsers()
        {
            var db = new BlogDbContext();
            foreach (var user in db.Users)
            {
                Console.WriteLine(user.UserName);
            }
        }
    }
}
