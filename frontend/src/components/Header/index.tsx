import logo from '../../assets/img/logo.svg';
import './styles.css';

function Header() {
    return (
        <>
            <header>
                <div className="dsmeta-logo-cointainer">
                    <img src={logo} alt="DSMeta"/>
                        <h1>DSMeta</h1>
                        <p>
                            Desenvolvido por
                            <a href="https://www.instagram.com/will_fs.__/"> @will_fs_.</a>
                        </p>
                </div>
            </header>
        </>
    )
}

export default Header;