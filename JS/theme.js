// 获取当前主题
const currentTheme = localStorage.getItem('theme') ? localStorage.getItem('theme') : null;

if (currentTheme) {
    document.documentElement.setAttribute('data-theme', currentTheme);

    if (currentTheme === 'dark') {
        toggleDarkLightMode(true);
    }
}

// 监听切换按钮的变化
document.getElementById('theme-toggle').addEventListener('change', function(event){
    if(event.target.checked){
        document.documentElement.setAttribute('data-theme','dark');
        localStorage.setItem('theme','dark');
    } else {
        document.documentElement.setAttribute('data-theme','light');
        localStorage.setItem('theme','light');
    }
    
});