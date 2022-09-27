public class Fibo implements Command 
{
    public String name() 
    {
        return "fibo";
    }
    public Boolean run(Scanner scanner) 
    {
        System.out.println("Entrez un nombre n :");
        int nb = Integer.parseInt(scanner.nextLine());
        if (nb < 0) 
        {
            System.out.println("Le nombre doit être positif");
        } 
        else 
        {
            System.out.println("f("+nb+") = " + Launcher.fibo(nb));
        }
        return false;
    }
}