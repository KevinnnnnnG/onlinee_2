<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand text-white" href="index.jsp">D-Compras</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a  class="nav-link text-white"  href="ControladorCU?action=inicio">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                        <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                    </svg>
                    Inicio
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="ControladorCU?action=Carrito">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                        <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
                    </svg>
                    <i>(<label style="color: white">${contador}</label>)</i> 
                    Carrito
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
    </div>
</nav>