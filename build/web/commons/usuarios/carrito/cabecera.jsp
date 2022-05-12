<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="index.jsp">D-Compras</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link text-white" href="ControladorCU?action=inicio">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16">
                        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                    </svg>
                    Seguir Comprando
                </a>
            </li>
        </ul>
    </div>
    <div class="dropdown dropleft">
        <a class="navbar-brand " data-toggle="dropdown">
            <img src="img/Usr.png" alt="Logo" style="width:40px;">
        </a>
        <div  style=" width:200px;" class="dropdown-menu">
            <center><img src="img/Usr.png"  style="width:100px;"></center>
            <center><a>${ usu.getNombres() }</a></center>
            <center><a>${usu.getCorreo() }</a></center>
            <div class="dropdown-divider"></div>
            <center>
                <a class="dropdown-item" href="UsuarioPerfil.jsp">Perfil</a>
                <a class="dropdown-item" href="index.jsp">Cerrar Sesion</a>
            </center>
        </div>
</nav>